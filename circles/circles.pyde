import random

game_objects = []

class Circle:
    def __init__(self, x, y):
        '''Create a new circle at the given x,y point with a random speed,
        color, and size.'''

        self.x = x
        self.y = y
        self.x_speed = random.randint(-5,5)
        self.y_speed = random.randint(-5,5)
        self.color = color(random.randint(0,255),
                           random.randint(0,255),
                           random.randint(0,255))
        self.size = random.randint(5,75)

    def update(self):
        '''Update current location by speed.'''

        self.x += self.x_speed
        self.y += self.y_speed

    def draw(self):
        '''Draw self on the canvas.'''

        fill(self.color) # set shape color
        stroke(0,0,0) # add a black outline
        ellipse(self.x, self.y, self.size, self.size)


def addCircle():
    '''Add a new circle where the user clicked.'''

    global game_objects
    game_objects.append(Circle(mouseX, mouseY))


def reset():
    '''Clear all game objects.'''

    global game_objects
    game_objects = []


def setup():
    size(400, 400)


def draw():
    '''Clear the screen, have all game objects update and redraw.'''

    global game_objects
    
    background(255, 255, 255) # draw a white background
    
    for game_object in game_objects:
        game_object.update()
        game_object.draw()


def mouseClicked():
    addCircle()


def keyPressed():
    if key == 'r':
        reset()
