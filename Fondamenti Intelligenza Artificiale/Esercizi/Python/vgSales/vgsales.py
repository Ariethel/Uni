import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.preprocessing import OneHotEncoder
from sklearn.compose import ColumnTransformer
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_absolute_error

#Voglio trovare il numero di vendite globali basandomi sulle altre feature
df = pd.read_csv('vgsales.csv')
y = df['NA_Sales']

columns_to_be_deleted = ['Rank', 'Name', 'NA_Sales']
df.drop(columns_to_be_deleted, axis=1, inplace=True)


transformers = [['one_hot', OneHotEncoder(), ['Platform', 'Genre', 'Year', 'Publisher']]]

ct = ColumnTransformer(transformers, remainder='passthrough')

X = ct.fit_transform(df)
X_train, X_test, y_train, y_test = train_test_split(X, y)

model = LinearRegression()
model.fit(X_train, y_train)

p_train = model.predict(X_train)
p_test = model.predict(X_test)

mae_train = mean_absolute_error(p_train, y_train)
mae_test = mean_absolute_error(p_test, y_test)

sns.scatterplot(x=p_train, y=y_train)
sns.scatterplot(x=p_test, y=y_test)
plt.show()

print(f'Mae Train {mae_train}, Mae Test {mae_test}')

