import pygame
import random

# Initialize Pygame
pygame.init()

# Screen dimensions
SCREEN_WIDTH = 800
SCREEN_HEIGHT = 600

class Player:
    def __init__(self, x, y):
        self.image = pygame.Surface((32, 32))
        self.image.fill((0, 255, 0))
        self.rect = self.image.get_rect()
        self.rect.topleft = (x, y)
        self.speed = 5

    def update(self, game_map):
        keys = pygame.key.get_pressed()
        if keys[pygame.K_LEFT]:
            self.rect.x -= self.speed
            if game_map.is_collision(self.rect):
                self.rect.x += self.speed
        if keys[pygame.K_RIGHT]:
            self.rect.x += self.speed
            if game_map.is_collision(self.rect):
                self.rect.x -= self.speed
        if keys[pygame.K_UP]:
            self.rect.y -= self.speed
            if game_map.is_collision(self.rect):
                self.rect.y += self.speed
        if keys[pygame.K_DOWN]:
            self.rect.y += self.speed
            if game_map.is_collision(self.rect):
                self.rect.y -= self.speed

    def draw(self, screen):
        screen.blit(self.image, self.rect.topleft)

class Tile:
    def __init__(self, x, y, width, height, color):
        self.rect = pygame.Rect(x, y, width, height)
        self.color = color

    def draw(self, screen):
        pygame.draw.rect(screen, self.color, self.rect)


class Map:
    def __init__(self):
        self.tiles = []
        self.create_map()

    def create_map(self):
        tile_size = 32
        for i in range(0, SCREEN_WIDTH, tile_size):
            for j in range(0, SCREEN_HEIGHT, tile_size):
                if random.choice([True, False]):
                    tile = Tile(i, j, tile_size, tile_size, (255, 255, 255))
                else:
                    tile = Tile(i, j, tile_size, tile_size, (0, 0, 0))
                self.tiles.append(tile)

    def draw(self, screen):
        for tile in self.tiles:
            tile.draw(screen)

    def is_collision(self, rect):
        for tile in self.tiles:
            if tile.color == (255, 255, 255) and tile.rect.colliderect(rect):
                return True
        return False


class NPC:
    def __init__(self, x, y, message):
        self.image = pygame.Surface((32, 32))
        self.image.fill((0, 0, 255))
        self.rect = self.image.get_rect()
        self.rect.topleft = (x, y)
        self.message = message

    def draw(self, screen):
        screen.blit(self.image, self.rect.topleft)

    def talk(self):
        print(self.message)

class Game:
    def __init__(self):
        self.screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
        pygame.display.set_caption("Pokemon-like RPG Game")
        self.clock = pygame.time.Clock()
        self.running = True

        self.player = Player(100, 100)
        self.map = Map()

        # Create NPCs
        self.npcs = [NPC(200, 200, "Hello, traveler!"), NPC(400, 400, "Stay away from the dark forest!")]

    def run(self):
        while self.running:
            self.events()
            self.update()
            self.draw()
            self.clock.tick(60)
        pygame.quit()

    def events(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                self.running = False
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    for npc in self.npcs:
                        if self.player.rect.colliderect(npc.rect):
                            print(npc.message)

    def update(self):
        self.player.update(self.map)

    def draw(self):
        self.screen.fill((0, 0, 0))
        self.map.draw(self.screen)
        self.player.draw(self.screen)
        for npc in self.npcs:
            npc.draw(self.screen)
        pygame.display.flip()


if __name__ == "__main__":
    game = Game()
    game.run()
