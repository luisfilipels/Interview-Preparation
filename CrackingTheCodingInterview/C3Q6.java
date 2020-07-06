import java.util.LinkedList;

public class C3Q6 {

    static class Animal {
        int order;
        Animal(int order) {
            this.order = order;
        }
    }

    static class Dog extends Animal {
        Dog(int order) {
            super(order);
        }
    }

    static class Cat extends Animal {
        Cat(int order) {
            super(order);
        }
    }

    static class AdoptionQueue {
        LinkedList<Animal> queueDogs = new LinkedList<>();
        LinkedList<Animal> queueCats = new LinkedList<>();

        int currentOrder = 0;

        void enqueue (Animal newAnimal) {
            if (newAnimal.getClass() == Dog.class) {
                System.out.println("Adding dog with order " + currentOrder);
                queueDogs.add(newAnimal);
            } else {
                System.out.println("Adding cat with order " + currentOrder);
                queueCats.add(newAnimal);
            }
            currentOrder++;
        }

        int dequeueAny() {
            try {
                if (queueDogs.getFirst().order > queueCats.getFirst().order) {
                    System.out.println("Removing cat with order " + queueCats.getFirst().order);
                    return queueCats.removeFirst().order;
                } else {
                    System.out.println("Removing dog with order " + queueDogs.getFirst().order);
                    return queueDogs.removeFirst().order;
                }
            } catch (Exception e) {
                if (queueCats.isEmpty()) {
                    System.out.println("Removing dog with order " + queueDogs.getFirst().order);
                    return queueDogs.removeFirst().order;
                } else if (queueDogs.isEmpty()) {
                    System.out.println("Removing cat with order " + queueCats.getFirst().order);
                    return queueCats.removeFirst().order;
                }
                System.out.println("Error!");
                return -1;
            }

        }

        int dequeueDog() {
            System.out.println("Removing dog with order " + queueDogs.getFirst().order);
            return queueDogs.removeFirst().order;
        }

        int dequeueCat() {
            System.out.println("Removing cat with order " + queueCats.getFirst().order);
            return queueCats.removeFirst().order;
        }

    }

    public static void main(String[] args) {
        AdoptionQueue queue = new AdoptionQueue();
        queue.enqueue(new Dog(queue.currentOrder));
        queue.enqueue(new Cat(queue.currentOrder));
        queue.enqueue(new Dog(queue.currentOrder));
        queue.enqueue(new Dog(queue.currentOrder));
        queue.enqueue(new Cat(queue.currentOrder));
        queue.enqueue(new Cat(queue.currentOrder));
        queue.enqueue(new Dog(queue.currentOrder));
        queue.enqueue(new Cat(queue.currentOrder));
        queue.dequeueAny();
        queue.dequeueAny();
        queue.dequeueDog();
        queue.dequeueAny();
        queue.dequeueCat();
        queue.dequeueAny();

    }
}
