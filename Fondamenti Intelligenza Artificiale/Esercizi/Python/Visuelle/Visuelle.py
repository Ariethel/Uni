import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.compose import ColumnTransformer
df = pd.read_csv('train.csv')

sns.barplot(data=df, x='external_code', y='0')
plt.show()