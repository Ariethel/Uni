from sklearn.neural_network import MLPClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
import numpy as np

#genero un dataset casuale di 100 righe e 5 features senza relazioni tra loro
n = 100
X = np.random.random(size=(n, 5))

#genero un target causale si/no (100)
y = np.random.choice(['si', 'no'], size=n)


#Splitto il dataset
X_train, X_test, y_train, y_test = train_test_split(X, y)


#Rete neurale
#per creare underfitting basterebbe dare 1 come numero di hidden layer
model = MLPClassifier(hidden_layer_sizes=[1000, 500], verbose=2)
model.fit(X_train, y_train)


p_train = model.predict(X_train)
p_test = model.predict(X_test)

score_train = accuracy_score(y_train, p_train)
score_test = accuracy_score(y_test, p_test)

print(f'Train score: {score_train} Test score: {score_test}')