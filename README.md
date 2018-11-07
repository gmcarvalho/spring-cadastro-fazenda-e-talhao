# spring-cadastro-fazenda-e-talhao

Esse é um projeto Spring,

primeiramente foi configurado as dependências do projeto no pom.xml: Todas as dependências usadas estão comentadas para melhor entendimento.

 <properties>
 
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>

		<failOnMissingWebXml>false</failOnMissingWebXml>

		<java.version>1.8</java.version>
		<maven-compiler-pluging.version>3.2</maven-compiler-pluging.version>
		<flyway-maven-plugin.version>4.0.2</flyway-maven-plugin.version>
		<mysql-connector-java.version>5.1.44</mysql-connector-java.version>

		<!-- Spring MVC -->
		<spring-framework.version>4.3.0.RELEASE</spring-framework.version>

		<!-- Servlet API -->
		<servlet.version>3.1.0</servlet.version>
		
		<!-- Thymeleaf -->
		<thymeleaf.version>3.0.0.RELEASE</thymeleaf.version>
		
		<!-- Bean Validation / Hibernate Validator -->
		<hibernate-validator.version>5.2.4.Final</hibernate-validator.version>
		
		<!-- Thymeleaf - Layout Dialect -->
		<thymeleaf-layout-dialect.version>2.2.2</thymeleaf-layout-dialect.version>
		
		<!-- Logging -->
		<log4j.version>2.6</log4j.version>
		<jcl-over-slf4j.version>1.7.21</jcl-over-slf4j.version>
		
		<!-- JPA / Hibernate -->
		<hibernate.version>5.2.3.Final</hibernate.version>
	</properties>

	<build>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>${maven-compiler-pluging.version}</version>
				<configuration>
					<source>${java.version}</source>
					<target>${java.version}</target>
				</configuration>
			</plugin>
			
			<plugin>
				<groupId>org.flywaydb</groupId>
				<artifactId>flyway-maven-plugin</artifactId>
				<version>${flyway-maven-plugin.version}</version>
				<configuration>
					<driver>com.mysql.jdbc.Driver</driver>
				</configuration>
			</plugin>
		</plugins>
	</build>

	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-framework-bom</artifactId>
				<version>${spring-framework.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<dependencies>
		<!-- Spring MVC -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<scope>compile</scope>
			<exclusions>
				<exclusion>
					<groupId>commons-logging</groupId>
					<artifactId>commons-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		
		<!-- Servlet API -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>${servlet.version}</version>
			<scope>provided</scope>
		</dependency>

		<!-- Thymeleaf -->
		<dependency>
			<groupId>org.thymeleaf</groupId>
			<artifactId>thymeleaf</artifactId>
			<version>${thymeleaf.version}</version>
			<scope>compile</scope>
		</dependency>

		<dependency>
			<groupId>org.thymeleaf</groupId>
			<artifactId>thymeleaf-spring4</artifactId>
			<version>${thymeleaf.version}</version>
			<scope>compile</scope>
		</dependency>
		
		<!-- Bean Validation / Hibernate Validator -->
  		<dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>${hibernate-validator.version}</version>
            <scope>compile</scope>
        </dependency>
        
        <!-- Thymeleaf - Layout Dialect -->
		<dependency>
    		<groupId>nz.net.ultraq.thymeleaf</groupId>
    		<artifactId>thymeleaf-layout-dialect</artifactId>
    		<version>${thymeleaf-layout-dialect.version}</version>
		</dependency>
		
		<!-- Logging -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-slf4j-impl</artifactId>
			<version>${log4j.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-api</artifactId>
			<version>${log4j.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>${log4j.version}</version>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>jcl-over-slf4j</artifactId>
			<version>${jcl-over-slf4j.version}</version>
		</dependency>
		
		<!-- JPA / Hibernate -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-entitymanager</artifactId>
			<version>${hibernate.version}</version>
			<scope>compile</scope>
		</dependency>

		<!-- Hibernate - Java 8 support -->
        <dependency>
    		<groupId>org.hibernate</groupId>
    		<artifactId>hibernate-java8</artifactId>
    		<version>${hibernate.version}</version>
    		<scope>compile</scope>
		</dependency>
		
		<!-- MySQL Driver -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>${mysql-connector-java.version}</version>
			<scope>provided</scope>
		</dependency>
	
	</dependencies>


Após a configuração do Projeto configurei o WebConfig, e o AppInitialize

Estamos usando o Thymeleaf como integração de front-end, portanto além da dependência no Maven que já está acima vamos instalar o plugin 
 
Em help > Install new Software > Adcionar o endereço do Plugin do Thymeleaf: http://www.thymeleaf.org/eclipse-plugin-update-site/

O Workspace irá reiniciar após essa instalação.

É preciso acompanhar a versão do tymeleaf dialect, estou utilizando agora a versão 2.2.2 no pom.xml, assim como outras dependências
Para esse projeto estamos utilizando o Apache Tomcat 8.5 
E estamos usando o Jrebel para auxílio do redeploy. 

Ao rodar o projeto, vamos chamar a url: localhost/farm/fazendas/novo que é o controller que está configurado para chamar uma página até o momento.

A persistência do banco de dados será feita utilizando o FlyWay, portanto assim que essa persistência estiver pronta lançarei mais uma versão. Enquanto isso já dá pra ir configurando o ambiente,
utilizando o servidor, tratativa de log, explorando um pouco o thymeleaf, e alguns recursos do projeto como um todo.






