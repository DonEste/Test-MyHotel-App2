# MyHotel Test

## Compilar el proyecto
	
	./mvnw clean package
	
## ejecutar el proyecto... 
	
    Finalmente por razones que no he comprendido aún, me sale el siguiente error: java.io.StreamCorruptedException: invalid stream header: 31393837... Y con eso no vale la pena seguir avanzando sin corregirlo :(
    Lo planeo arreglar antes de morir, pero ya no alcancé al plazo de 24 horas que se especificó en el correo.
	
    java -jar target/test-myhotel-0.0.1-SNAPSHOT.jar

## BD:
    Se debe configurar la conexión a alguna BD MySQL para que se creen las tablas necesarias, que en este caso son la tabla vehiculos y la tabla mantenciones
	
## El endpoint que planeaba hacer era el siguiente:

	Buscar empleados bajo ciertos filtros (POST)
		http://localhost:8080/employee/
			Body:
			{
                "table": ["employees", "departments", "location"], 
                "grouped_by": department,
                "conditions": [
                    {
                        "field": "employees.salary", 
                        "criteria": ">", 
                        "value": 3500
                    },
                    {
                        "field": "employees.salary", 
                        "criteria": "<", 
                        "value": 8000
                    }
                    ],
                "grouped": [
                    "copuntry", 
                    "department"
                ], 
                "secialfields":[
                    "max(employee.salary)", 
                    "min(employee.salary)"
                ]
            }
    
    Si, se ve algo complicado, pero no imposible... Seguro que me falta algo por corregir que no permite que se pueden cumplir todas las condiciones listadas en el PDF, pero esperaba iterar un poco para pulir eso :(
    
	
## GIT Repository
	https://github.com/DonEste/Test-MyHotel-App2
	