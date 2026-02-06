import java.util.List;

class Main{
    public static void main(String[] args){
        BurgerMeal plainBurger = new BurgerMeal.BurgerBuilder("wheat", "veg").build();
        BurgerMeal deluxeBurger = new BurgerMeal.BurgerBuilder("wheat", "veg")
                .withCheese(true)
                .withToppings(List.of("lettuce", "tomato", "onion"))
                .withSide("fries")
                .withDrink("cola")
                .build();
    }
}