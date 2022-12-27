from sklearn.compose import ColumnTransformer
from sklearn.preprocessing import OneHotEncoder

#Dataset inventanto di giocatori [peso, altezza, sport]
X = [
    [110, 1.70, 'rugby'],
    [100, 1.90, 'basket'],
    [120, 1.90, 'rugby'],
    [70, 1.60, 'soccer']
]


#ColumnTransormer ti dice "per questa colonna voglio operare questa trasformazione"
#Il OneHoteEncoder trasforma ogni possibile feature in una stringa binaria (vedi immagini)
transfomers = [
    ['categoryVectorizer', OneHotEncoder(), [2]] #nome arbitrario, classe da chiamare e colonna di applicazione
]

ct = ColumnTransformer(transfomers, remainder='passthrough')
 
ct.fit(X)
#Trasformo in numeri la mie feature
X = ct.transform(X)

print(X)
