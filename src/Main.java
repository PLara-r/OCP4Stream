import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
// 1) создание стрим
        Stream<String> empty = Stream.empty();    // count = 0
        Stream<Integer> singleElement = Stream.of(1);    // count = 1
        Stream<Integer> fromArray = Stream.of(1, 2, 3);    // count = 2

        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();
        //Строка 10 показывает, как создать пустой поток. Строка 11 показывает, как создать поток с одним элементом.
        // Строка 12 показывает, как создать поток из массива. Вы, несомненно, заметили, что в строке 12 нет массива.
        // Сигнатура метода использует varargs, что позволяет вам указать массив или отдельные элементы.

        //Строка 15 показывает, что это простой вызов метода для создания потока из списка.
        // Строка 16 делает то же самое, за исключением того, что создает поток, которому разрешено
        // обрабатывать элементы параллельно.  Использование параллельных потоков аналогично настройке нескольких
        // таблиц рабочих, которые могут выполнять одну и ту же задачу.  имейте в виду, что не стоит работать
        // параллельно для небольших потоков.

        // 2)связывание потоков с базовыми данными

          List<String> cats = new ArrayList<>();
           cats.add("Annie");
           cats.add("Ripley");
           Stream<String> stream = cats.stream();
           cats.add("KC");
           System.out.println(stream.count());
//Строки 20–22 создают Listс двумя элементами. Строка 23 запрашивает создание потока из этого List.
// Помните, что потоки лениво оцениваются. Это означает, что поток на самом деле не создается в строке 23.
// Создается объект, который знает, где искать данные, когда они необходимы. В строке 24, Listполучает новый элемент.
// На линии 25 потоковый конвейер фактически работает. Сначала запускается потоковый конвейер,
// глядя на источник и видя три элемента.


        //3) Собираем трубопровод (источник, промежуточные операции, результат)

        List<String> list1 = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        list1.stream().filter(n -> n.length() == 4).sorted()
                .limit(2).forEach(System.out::println);

        //Допустим, мы хотели получить первые два имени в алфавитном порядке длиной четыре символа
        // сначала находим стринг объекты длиной 4 символа,
        // затем сортируем их в алфавитном порядке, потом мы хотим первые два и распечатываем их.Вывод Alex Anna


    }
}
