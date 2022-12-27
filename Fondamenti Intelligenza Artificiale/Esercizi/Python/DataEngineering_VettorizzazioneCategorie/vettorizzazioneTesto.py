from sklearn.feature_extraction.text import CountVectorizer

#dataset testi
X = ['ciao ciao miao', 'miao', 'miao bao']

#Con bad of words creo una feature (colonna) diversa per ogni parola, che setto ad 1 solo quando
#compare nel testo corrispondente

vectorizer = CountVectorizer()
vectorizer.fit(X)

X = vectorizer.transform(X)
print(vectorizer.get_feature_names_out())
print(X.todense())

#stampa una matrice sparsa, (indice frase, indice parola -> Quante volte e' contenuta)
print(X)
