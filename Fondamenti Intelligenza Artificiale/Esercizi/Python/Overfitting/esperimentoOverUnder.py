import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.neural_network import MLPRegressor
from sklearn.metrics import mean_absolute_error
from sklearn.model_selection import train_test_split


# 0, 0.2, 0.4 ... fino a 10
X = np.arange(0, 10, 0.2)
n = len(X)
#per ottenere la struttura di matrice di features
X = np.expand_dims(X, axis=1)

#rumore aggiunto
y = np.cos(X) + (2*np.random.random(n))

X_train, X_test, y_train, y_test = train_test_split(X, y)

#50 neuroni interni, 1000 iterazioni sui dati, tol forza ad andare avanti anche
# se non sta apprendendo niente
model = MLPRegressor(hidden_layer_sizes=[50], max_iter=10000, tol=0, verbose=2)
model.fit(X_train, y_train)

p_train = model.predict(X_train)
p_test = model.predict(X_test)
p = model.predict(X)

mae_test = mean_absolute_error(y_test, p_test)
mae_train = mean_absolute_error(y_train, p_train)
print(f'Train {mae_train}, Test {mae_test}')

#riconverto in array monodimensionali
sns.scatterplot(x=X_train[:, 0], y=y_train)
sns.scatterplot(x=X_test[:, 0], y=y_test)
sns.lineplot(x=X[:, 0], y=p)
plt.show()
