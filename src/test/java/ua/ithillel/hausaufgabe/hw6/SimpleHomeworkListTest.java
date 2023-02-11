package ua.ithillel.hausaufgabe.hw6;

class SimpleHomeworkListTest extends BaseHomeworkListTest {

    @Override
    public HomeworkList target() {
        return new SimpleHomeworkList();
    }

    //all the test are defined in parent class
}