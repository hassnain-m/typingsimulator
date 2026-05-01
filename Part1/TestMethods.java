class TestMethods{

public static void main(String[] args){
   testBurnout();
}

public static void testSlideBack(){
    Typist t = new Typist('①', "John", 0.5);
    for (int i=0; i<10; i++){ // progress the racer 10 steps
        t.typeCharacter();
    }
    System.out.println("Your progress is " + t.getProgress()); //expect 10
    t.slideBack(1);
    System.out.println("Your progress is " + t.getProgress()); //expect 9
    t.slideBack(2);
    System.out.println("Your progress is " + t.getProgress()); //expect 7
    t.slideBack(3);
    System.out.println("Your progress is " + t.getProgress()); //expect 4
    t.slideBack(3);
    System.out.println("Your progress is " + t.getProgress()); //expect 1
    t.slideBack(2);
    System.out.println("Your progress is " + t.getProgress()); //expect 0
    t.slideBack(1);
    System.out.println("Your progress is " + t.getProgress()); //expect 0
   t.slideBack(10);
    System.out.println("Your progress is " + t.getProgress()); //expect 0
    t.slideBack(-5);
    System.out.println("Your final progress is " + t.getProgress()); //expect 0

}

public static void testBurnout(){
    Typist t = new Typist('①', "John", 0.5);
    
    t.burnOut(4);
    System.out.println(t.isBurntOut()); //expect true
    System.out.println(t.getBurnoutTurnsRemaining()); //expect 4
    
    t.recoverFromBurnout();
    System.out.println(t.isBurntOut()); //expect true
    System.out.println(t.getBurnoutTurnsRemaining()); //expect 3
    
    t.recoverFromBurnout();
    System.out.println(t.isBurntOut()); //expect true
    System.out.println(t.getBurnoutTurnsRemaining()); //expect 2
    
    t.recoverFromBurnout();
    System.out.println(t.isBurntOut()); //expect true
    System.out.println(t.getBurnoutTurnsRemaining()); //expect 1
    
    t.recoverFromBurnout();
    System.out.println(t.isBurntOut()); //expect false
    System.out.println(t.getBurnoutTurnsRemaining()); //expect 0
    
    t.recoverFromBurnout();
    System.out.println(t.isBurntOut()); //expect false
    System.out.println(t.getBurnoutTurnsRemaining()); //expect 0
    
    t.burnOut(2);
    
    t.recoverFromBurnout();
    System.out.println(t.isBurntOut()); //expect true
    System.out.println(t.getBurnoutTurnsRemaining()); //expect 1
    
    t.recoverFromBurnout();
    System.out.println(t.isBurntOut()); //expect false
    System.out.println(t.getBurnoutTurnsRemaining()); //expect 0

    t.burnOut(-5);
    System.out.println(t.isBurntOut()); //expect false
    System.out.println(t.getBurnoutTurnsRemaining()); //expect 0
}

public static void testReset(){
    Typist t = new Typist('①', "John", 0.5);

    System.out.println(t.getProgress()); //expect 0
    System.out.println(t.getBurnoutTurnsRemaining()); //expect 0
    System.out.println(t.isBurntOut()); //expect false

    for (int i=0; i<4; i++){ //simulate t to type 4 characters
        t.typeCharacter();
    }

    t.burnOut(6);
    
    System.out.println(t.getProgress()); //expect 4
    System.out.println(t.getBurnoutTurnsRemaining()); //expect 6
    System.out.println(t.isBurntOut()); //expect true

    t.resetToStart();

    System.out.println(t.getProgress()); //expect 0
    System.out.println(t.getBurnoutTurnsRemaining()); //expect 0
    System.out.println(t.isBurntOut()); //expect false
}

public static void testAccuracy(){
   //testing object instantiation
   Typist t1 = new Typist('①', "John", 0); //testing the first boundary case
   System.out.println(t1.getAccuracy()); //expect 0.0
   Typist t2 = new Typist('②', "Jane", 1); //testing the second boundary case
   System.out.println(t2.getAccuracy()); //expect 1.0
   Typist t3 = new Typist('③', "jake", -3); //testing a -ve number
   System.out.println(t3.getAccuracy()); //expect 0.0
   Typist t4 = new Typist('④', "Joe", 3); //testing a +ve number outside the acceptable range
   System.out.println(t4.getAccuracy()); //expect 1.0
   Typist t5 = new Typist('⑤', "Jade", 0.76); //testing a number within the acceptable range
   System.out.println(t5.getAccuracy()); //expect  0.76
   Typist t6 = new Typist('⑥', "Jeremy", 0.01); //testing another number within acceptable range
   System.out.println(t6.getAccuracy()); //expect  0.01

   //testing in-game accuracy update
   Typist t7 = new Typist('⑦', "Jeffrey", 0.7); 
   t7.setAccuracy(-7);
   System.out.println(t7.getAccuracy()); //expect 0.0
   t7.setAccuracy(7);
   System.out.println(t7.getAccuracy()); //expect 1.0
   t7.setAccuracy(1);
   System.out.println(t7.getAccuracy()); //expect 1.0
   t7.setAccuracy(0);
   System.out.println(t7.getAccuracy()); //expect 0.0
   t7.setAccuracy(0.99);
   System.out.println(t7.getAccuracy()); //expect 0.99
   t7.setAccuracy(0.33);
   System.out.println(t7.getAccuracy()); //expect 0.33
}

public static void testTypeCharacter(){
    Typist t = new Typist('⑦', "Joseph", 0.9);
    System.out.println(t.getProgress()); //expect 0;

    t.typeCharacter();
    System.out.println(t.getProgress()); //expect 1;

    t.typeCharacter();
    System.out.println(t.getProgress()); //expect 2;

    t.typeCharacter();
    System.out.println(t.getProgress()); //expect 3;
}
}
