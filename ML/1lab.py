import pandas as pd

dataframe = pd.read_csv("oecd_bli_2015.csv")

# dataframe.info()

print(dataframe.head())

a = dataframe['Country'].value_counts()
print(a)



