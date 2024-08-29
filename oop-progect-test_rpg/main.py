from abc import ABC, abstractmethod

class Menu(ABC) :
    def __init__(self, menu_id, name, price) :
        self.menu_id = menu_id
        self.name = name
        self.price = price

    @abstractmethod
    def show_details(self):
            pass
        
    def __str__(self):
            return f"{self.name} - ${self.price:.2f}"

class MainDish(Menu):
    def __init__(self, menu_id, name, price, calories):
        super().__init__(menu_id, name, price)
        self.calories = calories

    def show_details(self):
        print (f"Main Dish: {self} | {self.calories} kcal")

class Drink(Menu):
    def __init__(self, menu_id, name, price, volume):
        super().__init__(menu_id, name, price)
        self.volume = volume

    def show_details(self):
        print(f"Drink: {self} | Volume: {self.volume} ml")

class Dessert(Menu):
    def __init__(self, menu_id, name, price, size):
        super().__init__(menu_id, name, price)
        self.size = size
        
    def show_details(self):
        print(f"Dessert: {self} | Size: {self.size}")

class Order:
    def __init__(self, order_id):
        self.order_id = order_id
        self.items = []
        self.total_price = 0.0

    def add_item(self, menu_item):
        self.items.append(menu_item)
        self.total_price += menu_item.price

    def cancel_order(self):
        self.items = []
        self.total_price = 0.0

    def show_order(self):
        print("======================================")
        print("               RECEIPT                ")
        print("======================================")
        print(f"Order ID: {self.order_id}")
        print("--------------------------------------")
        for item in self.items:
            item_details = f"{item.name} ({item.menu_id})"
            print(f"{item_details:<30} ${item.price:.2f}")
        print("--------------------------------------")
        print(f"Total Price: {' ' * 17} ${self.total_price:.2f}")
        print("======================================")
        print("")

                

class Restaurant:
    def __init__(self) -> None:
        self.menu_list = []
        self.orders = []

    def add_menu(self, menu_item):
        self.menu_list.append(menu_item)

    def cancle_order(self, menu_id):
        self.menu_list = [item for item in self.menu_list if item.menu_id != menu_id]
        
    def manage_order(self, order):
        self.orders.append(order)

    def show_all_orders(self):
        for order in self.orders:
            order.show_order()

if __name__ == "__main__" :
    
    Restaurant = Restaurant()

    # Add menu items
    dish = MainDish(1, "Spaghetti", 12.99, 450)
    drink = Drink(2, "Coke", 1.99, 500)
    dessert = Dessert(3, "Ice Cream", 4.99, "Medium")
    
    Restaurant.add_menu(dish)
    Restaurant.add_menu(drink)
    Restaurant.add_menu(dessert)
    
    # Create an order
    order = Order(101)
    order.add_item(dish)
    order.add_item(drink)
    Restaurant.manage_order(order)
    
    # Show order details
    order.show_order()