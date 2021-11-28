/*
 * resource.c
 *
 *  Created on: 11/apr/2013
 *      Author: user
 */

/*
 * RUSAGE_THREAD non restituisce i dati in modo completo o corretto.
 * Nel caso in cui si volesse usare printResourceUsage(), nel programma con i
 * thread usare RUSAGE_SELF
 */

#include "ourhdr.h"

struct timeb g_TStart, g_TStop;
struct rusage *g_RStart = NULL, *g_RStop = NULL;
struct rusage *g_RChildrenStart = NULL, *g_RChildrenStop = NULL;
struct rusage *g_RThreadStart = NULL, *g_RThreadStop = NULL;
short  countingStarted = FALSE, countingStopped = FALSE;

void startCounting()
{
	countingStarted = TRUE;

	ftime( &g_TStart);

	if (g_RStart == NULL)
		if ((g_RStart = malloc( sizeof(struct rusage))) == NULL)
				return;
	if (g_RChildrenStart == NULL)
		if ((g_RChildrenStart = malloc( sizeof(struct rusage))) == NULL)
				return;
	if (g_RThreadStart == NULL)
			if ((g_RThreadStart = malloc( sizeof(struct rusage))) == NULL)
					return;

	if (getrusage( RUSAGE_SELF, g_RStart) < 0)
		err_ret("Can't get starting values of resource usage");
	if (getrusage( RUSAGE_CHILDREN, g_RChildrenStart) < 0)
		err_ret("Can't get starting values of resource usage");
	if (getrusage( RUSAGE_THREAD, g_RThreadStart) < 0) // @suppress("Symbol is not resolved")
		err_ret("Can't get starting values of resource usage");
}

void stopCounting()
{
	if (countingStarted == TRUE) {
		countingStopped = TRUE;

		ftime( &g_TStop);

		if (g_RStop == NULL)
			if ((g_RStop = malloc( sizeof(struct rusage))) == NULL)
				return;
		if (g_RChildrenStop == NULL)
			if ((g_RChildrenStop = malloc( sizeof(struct rusage))) == NULL)
				return;
		if (g_RThreadStop == NULL)
			if ((g_RThreadStop = malloc( sizeof(struct rusage))) == NULL)
				return;

		if (getrusage( RUSAGE_SELF, g_RStop) < 0)
			err_ret("Can't get final values of resource usage");
		if (getrusage( RUSAGE_CHILDREN, g_RChildrenStop) < 0)
			err_ret("Can't get final values of resource usage");
		if (getrusage( RUSAGE_THREAD, g_RThreadStop) < 0) // @suppress("Symbol is not resolved")
			err_ret("Can't get final values of resource usage");
	}
}

void printResourceUsage(int who)
{
	if (countingStopped == FALSE)
		stopCounting();

	if(who == RUSAGE_SELF){
		 fprintf(stderr, "\nTotal Elapsed Time: %.3f\n", TimeDiffmSec(g_TStart, g_TStop));
		 fprintf(stderr, "Total Sys Time    : %.3f\n", TimeDiffuSec(g_RStart->ru_stime, g_RStop->ru_stime));
		 fprintf(stderr, "Total User Time   : %.3f\n", TimeDiffuSec(g_RStart->ru_utime, g_RStop->ru_utime));
		 fprintf(stderr, "Blocking I/O oper.: %ld (in) %ld (out)\n",
		 			g_RStop->ru_inblock-g_RStart->ru_inblock, g_RStop->ru_oublock-g_RStart->ru_oublock);

 		fprintf(stderr, "Max resident size : %ld\n", g_RStop->ru_maxrss);        /*  */
 		fprintf(stderr, "Integral shared memory size: %ld\n", g_RStop->ru_ixrss);         /* */
 		fprintf(stderr, "Integral unshared data size: %ld\n", g_RStop->ru_idrss);         /* */
 		fprintf(stderr, "Integral unshared stack size: %ld\n", g_RStop->ru_isrss);         /*  */
 		fprintf(stderr, "Page reclaims (soft page faults): %ld\n", g_RStop->ru_minflt);    /*  */
 		fprintf(stderr, "Page faults (hard page faults): %ld\n", g_RStop->ru_majflt);        /* ) */
 		fprintf(stderr, "# Swap operations: %ld\n\n", g_RStop->ru_nswap);         /* swaps */

	}
	else if (who == RUSAGE_CHILDREN)
	{
		fprintf(stderr, "\nTotal Elapsed Time: %.3f\n", TimeDiffmSec(g_TStart, g_TStop));
		fprintf(stderr, "Total Sys Time    : %.3f\n", TimeDiffuSec(g_RChildrenStart->ru_stime, g_RChildrenStop->ru_stime));
		fprintf(stderr, "Total User Time   : %.3f\n", TimeDiffuSec(g_RChildrenStart->ru_utime, g_RChildrenStop->ru_utime));
		fprintf(stderr, "Blocking I/O oper.: %ld (in) %ld (out)\n",
				g_RChildrenStop->ru_inblock-g_RChildrenStart->ru_inblock, g_RChildrenStop->ru_oublock-g_RChildrenStart->ru_oublock);

		fprintf(stderr, "Max resident size : %ld\n", g_RChildrenStop->ru_maxrss);        /*  */
		fprintf(stderr, "Integral shared memory size: %ld\n", g_RChildrenStop->ru_ixrss);         /* */
		fprintf(stderr, "Integral unshared data size: %ld\n", g_RChildrenStop->ru_idrss);         /* */
		fprintf(stderr, "Integral unshared stack size: %ld\n", g_RChildrenStop->ru_isrss);         /*  */
		fprintf(stderr, "Page reclaims (soft page faults): %ld\n", g_RChildrenStop->ru_minflt);    /*  */
		fprintf(stderr, "Page faults (hard page faults): %ld\n", g_RChildrenStop->ru_majflt);        /* ) */
		fprintf(stderr, "# Swap operations: %ld\n\n", g_RChildrenStop->ru_nswap);         /* swaps */
	}
	else if (who == RUSAGE_THREAD) // @suppress("Symbol is not resolved")
	{
		fprintf(stderr, "\nTotal Elapsed Time: %.3f\n", TimeDiffmSec(g_TStart, g_TStop));
		fprintf(stderr, "Total Sys Time    : %.3f\n", TimeDiffuSec(g_RThreadStart->ru_stime, g_RThreadStop->ru_stime));
		fprintf(stderr, "Total User Time   : %.3f\n", TimeDiffuSec(g_RThreadStart->ru_utime, g_RChildrenStop->ru_utime));
		fprintf(stderr, "Blocking I/O oper.: %ld (in) %ld (out)\n",
				g_RThreadStop->ru_inblock-g_RThreadStart->ru_inblock, g_RThreadStop->ru_oublock-g_RThreadStart->ru_oublock);

		fprintf(stderr, "Max resident size : %ld\n", g_RThreadStop->ru_maxrss);        /*  */
		fprintf(stderr, "Integral shared memory size: %ld\n", g_RThreadStop->ru_ixrss);         /* */
		fprintf(stderr, "Integral unshared data size: %ld\n", g_RThreadStop->ru_idrss);         /* */
		fprintf(stderr, "Integral unshared stack size: %ld\n", g_RThreadStop->ru_isrss);         /*  */
		fprintf(stderr, "Page reclaims (soft page faults): %ld\n", g_RThreadStop->ru_minflt);    /*  */
		fprintf(stderr, "Page faults (hard page faults): %ld\n", g_RThreadStop->ru_majflt);        /* ) */
		fprintf(stderr, "# Swap operations: %ld\n\n", g_RThreadStop->ru_nswap);         /* swaps */
	}

}

double getRealTime() {
	if (countingStarted == FALSE || countingStopped == FALSE)
		return 0.;
	else
		return TimeDiffmSec(g_TStart, g_TStop);
}

double getSysTime() {
	if (countingStarted == FALSE || countingStopped == FALSE ||
		g_RStop == NULL || g_RStart == NULL)
		return 0.;
	else
		return TimeDiffuSec(g_RStart->ru_stime, g_RStop->ru_stime);
}

double getUserTime() {
	if (countingStarted == FALSE || countingStopped == FALSE ||
		g_RStop == NULL || g_RStart == NULL)
		return 0.;
	else
		return TimeDiffuSec(g_RStart->ru_utime, g_RStop->ru_utime);
}
double TimeDiffmSec( struct timeb Start, struct timeb Stop)
{
	double diff;

	if (Stop.millitm < Start.millitm) {
		Stop.millitm += 1000;
		Stop.time -= 1;
	}
	diff = (double) (Stop.time - Start.time) + (Stop.millitm - Start.millitm) / 1000.;
	return diff;
}

double TimeDiffuSec( struct timeval Start, struct timeval Stop)
{
	if (Stop.tv_usec < Start.tv_usec) {
		Stop.tv_usec += 1000000;
		Stop.tv_sec -= 1;
	}
	return (double) (Stop.tv_sec - Start.tv_sec + (Stop.tv_usec - Start.tv_usec) / 1000000.);
}

