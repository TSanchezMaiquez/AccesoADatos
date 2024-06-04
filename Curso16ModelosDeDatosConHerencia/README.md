
# Diferencias entre herencias:


* mappedsuperclass: 
    - Tenemos clase abstracta (herencia)
      - La clase abstracta no tiene tabla
        - Los hijos heredan sus campos (esta clase solo tiene dni)
      
              @MappedSuperclass  // recordatorio de class abstract: no se puede instanciar
              public abstract class User {
              @Id
              @GeneratedValue(strategy = GenerationType.IDENTITY)
              protected Long id; 

              protected String dni;
              }
              
              @Entity //Hereda de la clase User. User no tendrá tabla
              public class Customer extends User{
    
* tableperclass:
    - Tenemos herencia pero la clase NO es abstracta
    - Todas las clases tienen tabla
    - Los campos de la clase padre APARECEN en los hijos
    - DA PROBLEMAS:  La pk debe ser AUTO:
    
              @Entity 
              @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
              public class Vehicle {
              @Id
              @GeneratedValue(strategy = GenerationType.AUTO)
              protected Long id;
  
      
*joined:
  - Tenemos herencia pero la clase NO es abstracta
  - Todas las clases tienen tabla
  - Los campos de la clase padre NO APARECEN en los hijos


    @Entity
    @Inheritance(strategy = InheritanceType.JOINED)
    public class Device {


*singleTable:
  - Dos unicas tablas: la del dueño, y account, la cual recoge todas las propiedades de las otras dos clases

        @Entity
        @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
        @DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
        public class Account {

