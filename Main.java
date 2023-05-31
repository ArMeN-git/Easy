public class Main
{
    public static void main(String[] args)
    {
        // DAO ն սարքել ու Add անել միշտ անում ենք
        StudentDAO dao = new StudentDAO();
        dao.AddStudents();

        // եթե ուզումա window
        // սարքել window, իրան փոխանցում ենք DAO օբյեկտը արդեն լցրաց student ներով
        MyWindow window = new MyWindow(dao);
        // ամեն տեսակի student ներին տպելու համար, կանչում ենք window ի համապատասխան ֆունկցիաները
        // ցույց տալ բոլորին
        window.ShowAllStudents();
        // ցույց տալ բոլորին grade երով sort արած
        window.ShowStudentsSortedByGrades();
        // ցույց տալ բոլորին name երով sort արած
        window.ShowStudentsSortedByAlphabetical();

        window.ShowSuperStudentInRed();

        // եթե չի ուզում window, մեր մեթոդները սովորական DAO ից կանչում ենք
//        dao.printStudentsAlphabetical();
//        dao.printStudentsGrades();
//        dao.primeAndPalindrome();
//        dao.FindNumber();
//        dao.PrintPrimeAverage();
//        dao.FixedAverage();
    }
}