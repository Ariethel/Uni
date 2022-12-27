from sklearn.metrics import mean_squared_error, mean_absolute_error, r2_score
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt


y = np.random.random(size = 100) * 10
#introduco l'errore sistematico (y/2)
errors = y/2 + (2 * (np.random.random(size = 100)) - 1)
#simulo che le mie predizioni siano quelle corrette piu' gli errori
p = y + errors

#sottrazione tra risposta vera e data, se si fa il quadrato si ha mse, altrimenti mae (piu' vicino a 0 e' meglio)
mse = mean_squared_error(y, p)
mae = mean_absolute_error(y, p)

#grafico
residui = y - p
sns.scatterplot(x=y, y=residui)
plt.show()
