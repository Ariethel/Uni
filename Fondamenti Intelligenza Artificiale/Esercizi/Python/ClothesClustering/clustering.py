import matplotlib as matplotlib
import matplotlib.pyplot as plt
import cv2
import numpy as np
from image_slicer import slice

img = cv2.imread("painting.png", -1)

def img_split(img, n):
    slice(img, n)


'''
   def img_split(img, row, col):
    M = img.shape[0] // row
    N = img.shape[1] // col
    tiles = [
        [img[x:x + M, y:y + N]
             for x in range(0, img.shape[0], M)
             for y in range(0, img.shape[1], N)]
    ]
    cv2.imshow("img", tiles[1][0])
    cv2.waitKey(0)
'''

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
    img_split(img, 9)

    #grid, r, c = img_split(img, row, col)
    #plot_grid(grid, r, c)
