package familyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        List<Person> personList = new ArrayList<>();
        String regexForTwoDates = "(\\d{2}\\/\\d{2}\\/\\d{4}) - (\\d{2}\\/\\d{2}\\/\\d{4})";
        String regexForDateName = "(\\d{2}\\/\\d{2}\\/\\d{4}) - ([A-Z][a-z]+ [A-Z][a-z]+)";
        String regexForNameDate = "([A-Z][a-z]+ [A-Z][a-z]+) - (\\d{2}\\/\\d{2}\\/\\d{4})";
        String regexForNameName = "([A-Z][a-z]+ [A-Z][a-z]+) - ([A-Z][a-z]+ [A-Z][a-z]+)";
        String regexForBornAtSameDate = "([A-Z][a-z]+ [A-Z][a-z]+) (\\d{2}\\/\\d{2}\\/\\d{4})";

        while (!(input = reader.readLine()).equals("End")) {
            Pattern patternForTwoDates = Pattern.compile(regexForTwoDates);
            Matcher matcherForTwoDates = patternForTwoDates.matcher(input);

            Pattern patternForDateName = Pattern.compile(regexForDateName);
            Matcher matcherForDateName = patternForDateName.matcher(regexForDateName);

            Pattern patternForNameDate = Pattern.compile(regexForNameDate);
            Matcher matcherForNameDate = patternForNameDate.matcher(input);

            Pattern patternForNameName = Pattern.compile(regexForNameName);
            Matcher matcherForNameName = patternForNameName.matcher(input);

            Pattern patternForBornAtSameDate = Pattern.compile(regexForBornAtSameDate);
            Matcher matcherForBornAtSameDate = patternForBornAtSameDate.matcher(input);
            if (matcherForTwoDates.find()) {
                Date firstDate = parseDate(matcherForTwoDates.group(1));
                Date secondDate = parseDate(matcherForTwoDates.group(2));
                if (!containsDate(firstDate, personList)) {
                    Person firstPerson = new Person(firstDate);
                    personList.add(firstPerson);
                }

                if (!containsDate(secondDate, personList)) {
                    Person secondPerson = new Person(secondDate);
                    personList.add(secondPerson);
                }
            } else if (matcherForDateName.find()) {
                Date firstDate = parseDate(matcherForDateName.group(1));
                String name = matcherForDateName.group(2);
                if (!containsDate(firstDate, personList)) {
                    Person firstPerson = new Person(firstDate);
                    personList.add(firstPerson);
                }
                if (!containsName(name, personList)) {
                    Person secondPerson = new Person(name);
                    personList.add(secondPerson);
                }
            } else if (matcherForNameDate.find()) {
                String name = matcherForNameDate.group(1);
                Date firstDate = parseDate(matcherForNameDate.group(2));
                if (!containsName(name, personList)) {
                    Person firstPerson = new Person(name);
                    personList.add(firstPerson);
                }
                if (!containsDate(firstDate, personList)) {
                    Person secondPerson = new Person(firstDate);
                    personList.add(secondPerson);
                }
                } else if (matcherForNameName.find()) {
                    String firstName = matcherForNameName.group(1);
                    String secondName = matcherForNameName.group(2);
                    if (!containsName(firstName, personList)) {
                        Person firstPerson = new Person(firstName);
                        personList.add(firstPerson);
                    }
                    if (!containsName(secondName, personList)) {
                        Person secondPerson = new Person(secondName);
                        personList.add(secondPerson);
                    }
                } else if (matcherForBornAtSameDate.find()) {
                    String currentName = matcherForBornAtSameDate.group(1);
                    Date date = parseDate(matcherForBornAtSameDate.group(2));

                    if(Objects.equals(personList.get(0).getName(),currentName)) {
                        personList.get(0).setDate(date);
                        continue;
                    }
                    else if(Objects.equals(personList.get(0).getDate(),date)) {
                        personList.get(0).setName(currentName);
                        continue;
                     }

                    if (containsDate(date, personList)) {
                        personList.stream().filter(x -> Objects.equals(x.getDate(),date)).findFirst().get().setName(currentName);
                    } else if (containsName(currentName, personList)) {
                        personList.stream().filter(x -> Objects.equals(x.getName(),currentName)).findFirst().get().setDate(date);
                    }
                } else {
                    Person person;
                    if (isValidDate(input)) {
                        person = new Person(parseDate(input));
                        personList.add(person);
                    } else {
                        person = new Person(input);
                        personList.add(person);
                    }
                }

        }
    }

    private static boolean containsName(String name, List<Person> personList) {
       // return personList.stream().anyMatch(x -> x.getName().equals(name));
        return personList.stream().anyMatch(x -> Objects.equals(x.getName(),name));
    }

    private static boolean containsDate(Date date, List<Person> personList) {
        return personList.stream().anyMatch(x -> Objects.equals(x.getDate(),date));
    }


    private static Date parseDate(String str) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(str);
    }

    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}
