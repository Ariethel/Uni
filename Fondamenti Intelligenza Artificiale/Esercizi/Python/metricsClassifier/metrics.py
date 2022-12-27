import numpy as np
import scikitplot as skplt
from sklearn.metrics import accuracy_score, precision_score, recall_score, f1_score, classification_report
import matplotlib.pyplot as plt

def randomize(v, lab, prob=0.2):
    v2 = []
    for el in v:
        if np.random.random() > prob:
            v2.append(el)
        else:
            v2.append(np.random.choice(lab))
    return v2

# cronaca, politica o sport
labels = ['cronaca', 'politica', 'sport']

y = np.random.choice(labels, 1000)
p = randomize(y, labels)

acc = accuracy_score(y, p)
print(f'Accuracy: {acc}')
print(f"Misclassification{1 - acc}")

report = classification_report(y, p)
print(report)

#creo la matrice di confusione

skplt.metrics.plot_confusion_matrix(y, p)
plt.show()