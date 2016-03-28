/*

README
------

Below there's a class called Challenge with only one method: main.

Your mission, should you choose to accept it, is to add codes ONLY in the sections labeled "PLACE YOUR CODE HERE"
in order to:

1. Make this file compiles without any errors, and

2. Make the resulting application prints as many "true"s as possible. That is, the expected result is something like
   this:

    1.1 : true
    1.2 : true
    2.1 : true
    2.2 : true
    3.1 : true
    3.2 : true


Submission Instructions:
------------------------

1. Create a Java project with your name as the name of the project.
2. Complete your mission and ensure and all have been following the above guidelines.
3. Compress the entire project into a file OR push the project into a GIT repository
4. Submit the link to your answer (uploaded file or repository) to http://bit.ly/mastercodesubmission

*/


public class Challenge {
    public static void main(String[] args) {
        //
        // 1. Change car engine
        //
        Car car = new Car();
        Engine v6Engine = new V6Engine();

        // PROBLEM
        double v6EngineSpeed = car.getMaxSpeed();
        System.out.println("1.1 : " + (v6EngineSpeed == v6Engine.getMaxSpeed()));

        Engine turbopropEngine = new TurbopropEngine();
        car.changeEngine(turbopropEngine);
        double turbopropEngineSpeed = car.getMaxSpeed();

        // PROBLEM
        System.out.println("1.2 : " + (turbopropEngineSpeed > v6EngineSpeed));


        //
        // 2. Custom HTML-like markup language
        //
        MarkupElement root = new RootElement("[customml]", "[/customml]");
        MarkupElement body = new BodyElement("[body]", "[/body]");
        MarkupElement italic = new ItalicElement("[i]", "[/i]");

        italic.setContent("I am italic.");

        // PROBLEM
        System.out.println("2.1 : " + italic.produceOutput()
                .equals("[i]I am italic.[/i]"));

        root.addChildren(body);
        body.addChildren(italic);

        System.out.println("2.2 : " + root.produceOutput()
                .equals("[customml][body][i]I am italic.[/i][/body][/customml]"));



        //
        // 3. Implement stack that will output n items at once
        //
        WeirdStack<Integer> weirdStack = new WeirdStack<Integer>(2); // will output 2 items at once.
        weirdStack.push(1);
        weirdStack.push(2);
        weirdStack.push(3);

        java.util.List<Integer> popped = weirdStack.pop();
        // PROBLEM: Verify that popped is [3, 2]
        System.out.println("3.1 : " + popped.equals(java.util.Arrays.asList(3, 2)));

        weirdStack.setPopSize(3); // will output 3 items at once.
        weirdStack.push(4);
        weirdStack.push(5);

        java.util.List<Integer> poppedAgain = weirdStack.pop();
        // PROBLEM: Verify that poppedAgain is [5, 4, 1]
        System.out.println("3.2 : " + poppedAgain.equals(java.util.Arrays.asList(5, 4, 1)));
    }
}

//
// PROBLEM 1. Change car engine.
//
class Car {
    // PLACE YOUR CODE HERE
    Engine myEngine;
    
    Car(){
        myEngine = new V6Engine();
    }
    
    void changeEngine(Engine engine){
        myEngine = engine;
    }
    
    double getMaxSpeed(){
        return myEngine.getMaxSpeed();
    }
    
}

interface Engine {
    // PLACE YOUR CODE HERE
    double getMaxSpeed();
}
class V6Engine implements Engine {

    @Override
    public double getMaxSpeed() {
        return 5.0;
    }
    // PLACE YOUR CODE HERE
}
class TurbopropEngine implements Engine {

    @Override
    public double getMaxSpeed() {
        return 6.0;
    }
    // PLACE YOUR CODE HERE
}

//
// PROBLEM 2. Custom HTML-like markup language.
//
class MarkupElement {
    // PLACE YOUR CODE HERE
    String openTag;
    String closeTag;
    String content;
    java.util.List<MarkupElement> children;
    
    MarkupElement(){
        children = new java.util.ArrayList<MarkupElement>();
    }
    
    void setContent(String content){
        this.content = content;
    }
    String produceOutput(){
        String str=openTag;
        if(content!=null)
            str+=content;
        for(int i=0;i<children.size();i++){
            str+=children.get(i).produceOutput();
        }
        str+=closeTag;
        return str;
    }
    void addChildren(MarkupElement markupElement){
        children.add(markupElement);
    }
}
class RootElement extends MarkupElement {
    // PLACE YOUR CODE HERE
    RootElement(String openTag,String closeTag){
        this.openTag = openTag;
        this.closeTag=closeTag;
    }
}
class BodyElement extends MarkupElement {
    // PLACE YOUR CODE HERE
    BodyElement(String openTag,String closeTag){
        this.openTag = openTag;
        this.closeTag=closeTag;
    }
}
class ItalicElement extends MarkupElement {
    // PLACE YOUR CODE HERE
    ItalicElement(String openTag,String closeTag){
        this.openTag = openTag;
        this.closeTag = closeTag;
    }
}

//
// PROBLEM 3. Implement stack that will output n items at once.
//
class WeirdStack<T> {
    // PLACE YOUR CODE HERE
    
    java.util.List<T> value;
    Integer popSize;
    
    WeirdStack(Integer popSize){
        this.popSize =popSize;
        value = new java.util.ArrayList<T>();
    }
    void push(T value){
        this.value.add(value);
    }
    java.util.List<T> pop(){
        java.util.List<T> returnValue = new java.util.ArrayList<T>();
        
        for(int i=0;i<popSize;i++){
            if(value.size()>0){
                returnValue.add(value.get(value.size()-1));
                value.remove(value.size()-1);
            }
        }
        
        return returnValue;
    }
    void setPopSize(Integer popSize){
        this.popSize = popSize;
    }
}