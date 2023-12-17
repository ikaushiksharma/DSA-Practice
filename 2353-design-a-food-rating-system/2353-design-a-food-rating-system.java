class FoodRatings {
    HashMap<String, PriorityQueue<Food>> x = new HashMap<>();
    HashMap<String, Food> menu = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0;i<foods.length;i++){
            Food fo=new Food(foods[i],cuisines[i],ratings[i]);
            x.putIfAbsent(cuisines[i],new PriorityQueue<>((a,b)->a.rating==b.rating?(a.name.compareTo(b.name)):b.rating-a.rating));
            PriorityQueue<Food>pq=x.get(cuisines[i]);
            pq.add(fo);
            menu.put(foods[i],fo);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food fo=menu.get(food);
        PriorityQueue<Food> pq = x.get(fo.cuisine);
        pq.remove(fo);
        fo.rating=newRating;
        pq.add(fo);
    }
    
    public String highestRated(String cuisine) {
        return x.get(cuisine).peek().name;
    }
    class Food{
        int rating;
        String name,cuisine;
        Food(String name,String cuisine,int rating){
            this.name=name;
            this.cuisine=cuisine;
            this.rating=rating;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */