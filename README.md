# MyHotel Test

    Las querys solicitadas en el segudno ejercicio están en el archivo Querys.sql 

## Compilar el proyecto
	
	./mvnw clean package
	
## ejecutar el proyecto... 
	
    Finalmente por razones que no he comprendido aún, me sale el siguiente error: java.io.StreamCorruptedException: invalid stream header: 31393837... Y con eso no vale la pena seguir avanzando sin corregirlo :(
    Lo planeo arreglar antes de morir, pero ya no alcancé al plazo de 24 horas que se especificó en el correo.
	
    java -jar target/test2-MyHotel-0.0.1-SNAPSHOT.jar

## BD:
    Se debe configurar la conexión a alguna BD MySQL con el schema con los datos en el dump que se entregó para el ejercicio
    
    Los datos de el dump contienen dos errores que tienen que ser corregidos para que las relaciones en Hybernate pueda trabajar corectamente, lo que yo hice para solucionarlo fue lo siguiente:

    insert into countries values ('EN', 'Inglaterra', 1);
    update locations set country_id = 'EN' where country_id = 'OX';
    update employees set department_id = 10 where department_id = 0;
    commit;

    ... Podría haber dehecho las relaciones en cada entidad, pero perdí demasiado tiempo viendo qué estaba mal como para rehacer eso :(
	
## El endpoint que alcancé a hacer en el plazo es el siguiente:

	Buscar empleados bajo filtros de salario (POST) -- Ambos campos son opcionales
		http://localhost:8080/employeesBySalary/
			Body:
			{
                "lowRange": 3500,
                "highRange": 80000
            }

    Los demás no los alcancé a hacer en el plazo :(
    
	
## GIT Repository
	https://github.com/DonEste/Test-MyHotel-App2
	