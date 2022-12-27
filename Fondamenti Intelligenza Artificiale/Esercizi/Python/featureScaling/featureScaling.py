from sklearn.datasets import load_wine
#wrapper di matplot
import seaborn as sns
import matplotlib.pyplot as plt
import pandas as pd
from sklearn.preprocessing import MinMaxScaler
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score
dataset = load_wine()

#print(dataset['DESCR'])

#Bisogna normalizzare il range delle feature

#dal dataset prendo le colonne di indice 4 e 7
X = dataset['data'][:, [4, 7]]


#Sto andando a normalizzare la scala di valore delle feature
scaler = MinMaxScaler()
X = scaler.fit_transform(X)

df = pd.DataFrame(X, columns=['magnesium', 'phenols'])
g = sns.scatterplot(data=df, x='magnesium', y='phenols')
#plt.show()

#Provo a vedere l'accuracy senza scalare

X = dataset['data']
y = dataset['target']

model = KNeighborsClassifier()
model.fit(X, y)

p = model.predict(X)

acc_not_scaled = accuracy_score(y, p)
print(f'Accuracy not scaled: {acc_not_scaled}')

#Provo a vedere l'accuracy scalando

X = dataset['data']
y = dataset['target']

scaler = MinMaxScaler()
X = scaler.fit_transform(X)

model2 = KNeighborsClassifier()
model2.fit(X, y)

p = model2.predict(X)

acc_scaled = accuracy_score(y, p)
print(f'Accuracy scaled: {acc_scaled}')



