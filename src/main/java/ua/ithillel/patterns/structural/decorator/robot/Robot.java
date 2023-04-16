package ua.ithillel.patterns.structural.decorator.robot;

public interface Robot {
    void move();
    void scan();
}

class BasicRobot implements Robot {
    public void move() {
        System.out.println("Робот рухається.");
    }

    public void scan() {
        System.out.println("Робот сканує.");
    }
}

abstract class RobotDecorator implements Robot {
    protected Robot robot;

    public RobotDecorator(Robot robot) {
        this.robot = robot;
    }

    public void move() {
        robot.move();
    }

    public void scan() {
        robot.scan();
    }
}

class ShootingRobot extends RobotDecorator {
    public ShootingRobot(Robot robot) {
        super(robot);
    }

    public void move() {
        robot.move();
    }

    public void scan() {
        robot.scan();
    }

    public void shoot() {
        System.out.println("Робот стріляє.");
    }
}

class TeleportingRobot extends RobotDecorator {
    public TeleportingRobot(Robot robot) {
        super(robot);
    }

    public void move() {
        teleport();
        robot.move();
    }

    public void scan() {
        robot.scan();
    }

    public void teleport() {
        System.out.println("Робот телепортується.");
    }
}
