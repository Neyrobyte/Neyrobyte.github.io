import tkinter as tk
from PIL import Image, ImageTk

# Размеры изображения
WIDTH = 1800
HEIGHT = 1800

# Функция для вычисления цвета пикселя в зависимости от количества итераций
def mandelbrot(c, max_iter):
    z = 0
    n = 0
    while abs(z) <= 2 and n < max_iter:
        z = z*z + c
        n += 1
    return n

# Функция для создания изображения фрактала Мандельброта
def create_fractal_image(width, height, max_iter):
    image = Image.new("RGB", (width, height))
    pixels = image.load()

    for x in range(width):
        for y in range(height):
            # Масштабируем координаты пикселя в область фрактала
            re = (x - width/2.0) * 4.0/width
            im = (y - height/2.0) * 4.0/height
            c = complex(re, im)
            # Вычисляем количество итераций для текущей точки
            m = mandelbrot(c, max_iter)
            # Задаем цвет пикселя в зависимости от количества итераций
            color = 255 - int(m * 255 / max_iter)
            pixels[x, y] = (color, color, color)

    return image

# Создаем главное окно приложения
root = tk.Tk()
root.title("Фрактал Мандельброта")

# Создаем изображение фрактала
max_iter = 100
fractal_image = create_fractal_image(WIDTH, HEIGHT, max_iter)

# Преобразуем изображение в формат, который можно отобразить в tkinter
tk_image = ImageTk.PhotoImage(fractal_image)

# Создаем виджет для отображения изображения
label = tk.Label(root, image=tk_image)
label.pack()

# Запускаем главный цикл приложения
root.mainloop()