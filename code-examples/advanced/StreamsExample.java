public class StreamsExample {
    public void demonstrateStreams() {
        List<Person> people = getPeople();
        
        // Filtering and mapping
        List<String> adultNames = people.stream()
            .filter(p -> p.getAge() >= 18)
            .map(Person::getName)
            .collect(Collectors.toList());
            
        // Grouping
        Map<String, List<Person>> byCountry = people.stream()
            .collect(Collectors.groupingBy(Person::getCountry));
            
        // Statistics
        DoubleSummaryStatistics ageStats = people.stream()
            .mapToDouble(Person::getAge)
            .summaryStatistics();
            
        // Parallel streams
        double averageAge = people.parallelStream()
            .mapToDouble(Person::getAge)
            .average()
            .orElse(0.0);
            
        // Flat mapping
        List<String> allHobbies = people.stream()
            .flatMap(p -> p.getHobbies().stream())
            .distinct()
            .collect(Collectors.toList());
    }
}