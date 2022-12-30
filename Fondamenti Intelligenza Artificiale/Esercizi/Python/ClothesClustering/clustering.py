import matplotlib as matplotlib
import matplotlib.pyplot as plt
import cv2
import numpy as np
from image_slicer import slice

img = cv2.imread("painting.png", 0)

#Il nostro scopo e' quello di arrivare ad avere ogni immagine come A = [[array di immagini(matrici)], etichetta]
#per compararle pero' bisogna effettuare delle trasformazioni: Devono avere tutte la stessa risoluzione e devono essere normalizzate tutte le feature
#forse devono pure essere tutte in scala di grigi


def img_split(img, row, col):
    M = img.shape[0] // col #larghezza colonna
    N = img.shape[1] // row #larghezza riga
    print(f'Shape[0]:{img.shape[0]} Shape[1]:{img.shape[1]} M:{M} N: {N}')
    tiles = [[img[x:x + M, y:y + N] for x in range(0, img.shape[0], N) for y in range(1, img.shape[1], M)]]
    #Cosa cazzo succede qui? Chiedere a Lore, in pratica e' come se creasse una matrice di una sola riga ma molto larga
    cv2.imshow("img", tiles[0][9])
    cv2.waitKey(0)

def plot_grid(grid,row,col,h=5,w=5):
    fig, ax = plt.subplots(nrows=row, ncols=col)
    [axi.set_axis_off() for axi in ax.ravel()]

    fig.set_figheight(h)
    fig.set_figwidth(w)
    c = 0
    for row in ax:
        for col in row:
            col.imshow(np.flip(grid[c], axis=-1))
            c+=1
    plt.show()

if __name__=='__main__':
    row, col = 3, 3
    img_split(img, row, col)

    #grid, r, c = img_split(img, row, col)
    #plot_grid(grid, r, c)
