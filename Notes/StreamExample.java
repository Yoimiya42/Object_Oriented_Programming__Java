import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamExample
{
  private static ArrayList<Integer> values;
  static {
    Random random = new Random();
    values = new ArrayList<>();
    for(int i = 0 ; i < 100 ; i++) values.add(random.nextInt(1000));
  }

  public static void example1()
  {
    System.out.println("Original values are: " + values);
    Stream<Integer> stream = values.stream();
    List<Integer> result =
      stream
      .sorted()
      .skip(2)
      .limit(10)
      .collect(toList());
    System.out.println("Result values are: " + result);
  }

  public static void example2()
  {
    List<String> words = new ArrayList<>();
    words.add("Some");
    words.add("words");
    words.add("to");
    words.add("use");
    words.add("as");
    words.add("an");
    words.add("example");
    words.add("sentence");
    words.add("containing");
    words.add("some");
    words.add("words");

    long count = words.stream()                // Create stream
      .distinct()                              // Intermediate operations
      .filter(word -> word.length() >= 4)
      .count();                                // Terminal operation

    System.out.println(
      String.format("There are %d distinct words of 4 or more characters.", count));
    System.out.println("The words are: ");

  }

  public static void example3()
  {
    Stream<String> words = Stream.of(
      "Some", "words", "to", "use", "as", "an", "example",
      "sentence", "containing", "some", "words");

    List<String> fiveOrMore =
      words
      .distinct()
      .filter(word -> word.length() >= 4)
      .collect(toList());

    System.out.println("The words are: ");
    fiveOrMore.forEach(System.out::println);
  }

  public static void example4()
  {
    Stream<Integer> ints =
      Stream.of(54,6,23,456,466,234,45,23,352,14,1,7,678,2);
    ints
      .map(n -> n * 2)
      .forEach(System.out::println);

    // Can't do this with a stream that has already been used. A new
    // stream is needed.
    //    ints
    //      .map(n -> n * 3)
    //      .forEach(System.out::println);
  }

  public static void example5()
  {
    Stream<Integer> infiniteInts
      = Stream.iterate(100, n -> n + 2);

    int sum = infiniteInts
      .limit(100)
      .mapToInt(n -> n)// Streams are lazy - needed to pull next value.
      .sum();

    System.out.println("Sum is: " + sum);
  }

  public static void example6()
  {
    Stream<String> stream = Stream.of(new String[]{ "To", "be", "or", "not", "to", "be" });
    List<String> asList = stream
      .peek(s -> System.out.print (s + " "))
      .collect(Collectors.toList());
    System.out.println();
    System.out.println("Class of list is: " + asList.getClass());

    Set<String> asSet = asList.stream().collect(Collectors.toSet());
    System.out.println(asSet);
  }

  public static void example7()
  {
    Stream<String[]> stream = Stream.of(new String[][]
    {
      {"Hamlet Act Scene 1", "To be, or not, to be"},
      {"Romeo & Juliet Act 2 Scene 2", "Romeo, Romeo! Wherefore art thou, Romeo?"},
      {"Richard III Act 1 Scene 1", "NOw is the winter of our discontent"},
      {"Henry IV Pt 2 Act 3 Scene 2", "A man can die but once"},
      {"The Merchant of Venice Act 2 Scene 7", "All that glisters is not gold"}
    });
    Map<String, String> asMap = stream
      .peek(q -> System.out.println(String.format("%S: '%s'", q[0],q[1])))
      .collect (Collectors. toMap(
        q -> q[0],
        q-> q[1]
      ));
    System.out.println(asMap.keySet());
    System.out.println(asMap.values());
    System.out.println(asMap.get("Henry IV Pt 2 Act 3 Scene 2"));
  }

  public static void example8()
  {
    String[][] quotes = new String[][] {
    {"Hamlet Act 3 Scene 1", "Hamlet", "To be, or not, to be"},
    {"Romeo & Juliet Act 2 Scene 2", "Juliet", "Romeo, Romeo! Wherefore art thou, Romeo?"},
    {"Richard III Act 1 Scene 1", "Richard III", "NOw is the winter of our discontent"},
    {"Hamlet Act 1 Scene 3", "Polonius", "This above all, to thine own self be true"},
    {"Henry IV Pt 2 Act 3 Scene 2", "Feeble", "A man can die but once"},
    {"The Merchant of Venice Act 2 Scene 7", "Morocco", "All that glisters is not gold"}
    };

    for (String[] q : quotes)
    {
      if (q[0].contains("Hamlet"))
      {
        System.out.println(String.format("%s: %s", q[1], q[2]));
      }
    }

    Stream.of(quotes)
      .filter(q -> q[0].contains("Hamlet"))
      .forEach(q -> { System.out.println(String. format ("%s: %s", q[1], q[2])); });
  }

  public static void example9()
  {
    String[][] quotes = new String[][] {
      {"Hamlet Act 3 Scene 1", "Hamlet", "To be, or not, to be"},
      {"Romeo & Juliet Act 2 Scene 2", "Juliet", "Romeo, Romeo! Wherefore art thou, Romeo?"},
      {"Richard III Act 1 Scene 1", "Richard III", "NOw is the winter of our discontent"},
      {"Hamlet Act 1 Scene 3", "Polonius", "This above all, to thine own self be true"},
      {"Henry IV Pt 2 Act 3 Scene 2", "Feeble", "A man can die but once"},
      {"The Merchant of Venice Act 2 Scene 7", "Morocco", "All that glisters is not gold"}
    };

    Arrays. sort (quotes, new Comparator<String[]>()
    {
      @Override
      public int compare (String [] q1, String[] q2)
      {
        return q1[2]. compareTo(q2[2]);
      }
    });

    for (String[] q : quotes)
    {
      if (q[0].contains("Hamlet"))
      {
        System.out.println(String.format("%s: %s", q[1], q[2]));
      }
    }

    Stream.of(quotes)
      .filter(q -> q[0].contains("Hamlet"))
      .sorted((q1, q2) -> q1[2].compareTo(q2[2]))
      .forEach(q -> { System.out.println(String. format ("%s: %s", q[1], q[2])); });
  }

  public static void example10()
  {
    class Quote
    {
      private String quote;

      public Quote(String quote)
      {
        this.quote = quote;
      }

      public String getQuote()
      {
        return quote;
      }
    }

    String[][] quotes = new String[][] {
      {"Hamlet Act 3 Scene 1", "Hamlet", "To be, or not, to be"},
      {"Romeo & Juliet Act 2 Scene 2", "Juliet", "Romeo, Romeo! Wherefore art thou, Romeo?"},
      {"Richard III Act 1 Scene 1", "Richard III", "NOw is the winter of our discontent"},
      {"Hamlet Act 1 Scene 3", "Polonius", "This above all, to thine own self be true"},
      {"Henry IV Pt 2 Act 3 Scene 2", "Feeble", "A man can die but once"},
      {"The Merchant of Venice Act 2 Scene 7", "Morocco", "All that glisters is not gold"}
    };
    Stream.of (quotes)
      .map(q-> q[2])
      .filter(q -> Objects. nonNull(q))
      .peek(q -> System.out.println(q))
      .map(q -> q.toUpperCase())
      .map(q -> new Quote(q))
      .forEach(q -> System.out.println(q.getQuote()));
  }

  public static void main(String[] args)
  {
    example1();
    System.out.println("-------");
    example2();
    System.out.println("-------");
    example3();
    System.out.println("-------");
    example4();
    System.out.println("-------");
    example5();
    System.out.println("-------");
    example6();
    System.out.println("-------");
    example7();
    System.out.println("-------");
    example8();
    System.out.println("-------");
    example9();
    System.out.println("-------");
    example10();
  }
}
