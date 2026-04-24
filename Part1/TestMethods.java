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
}

}
