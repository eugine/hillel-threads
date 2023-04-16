package ua.ithillel.patterns.structural.facade;

class SubsystemA {
    public void operationA() {
        System.out.println("SubsystemA.operationA");
    }
}

class SubsystemB {
    public void operationB() {
        System.out.println("SubsystemB.operationB");
    }
}

class SubsystemC {
    public void operationC() {
        System.out.println("SubsystemC.operationC");
    }
}

class Facade {
    private final SubsystemA subsystemA = new SubsystemA();
    private final SubsystemB subsystemB = new SubsystemB();
    private final SubsystemC subsystemC = new SubsystemC();

    public void operation1() {
        System.out.println("Facade.operation1");
        subsystemA.operationA();
        subsystemB.operationB();
    }

    public void operation2() {
        System.out.println("Facade.operation2");
        subsystemB.operationB();
        subsystemC.operationC();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operation1();
        facade.operation2();
    }

}
