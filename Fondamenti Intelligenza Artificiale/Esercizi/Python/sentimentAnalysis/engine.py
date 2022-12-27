import pandas as pd
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import BernoulliNB
from sklearn.metrics import accuracy_score

df = pd.read_csv('movie_review.csv')

#stampo le prime 5 righe per vedere se e' stato letto correttamente da pandas
#print(df.head())


#isolo x e y
X = df['text']
y = df['tag']

#vettorizzo il testo
vectorizer = CountVectorizer(ngram_range=(1, 2))
X = vectorizer.fit_transform(X)

#splitto in dataset
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.40)

model = BernoulliNB()
model.fit(X_train, y_train)

p_train = model.predict(X_train)

p_test = model.predict(X_test)

acc_train = accuracy_score(y_train, p_train)
acc_test = accuracy_score(y_test, p_test)

print(f'Train acc. {acc_train}, Test acc.{acc_test}')
