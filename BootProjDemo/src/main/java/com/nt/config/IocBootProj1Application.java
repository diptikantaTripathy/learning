package com.nt.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.beans.WishGenerator;

@SpringBootApplication
@Import(value=AppConfig.class)
public class IocBootProj1Application {

	public static void main(String[] args) {
		/*ApplicationContext ctx=null;
		 WishGenerator generator=null;
		ctx=SpringApplication.run(IocBootProj1Application.class, args);
		//get Bean
		 generator=ctx.getBean("wish",WishGenerator.class);
		 generator.generateWishMessage("raja");
		//invoke methods
		 System.out.println("Wish Message::::"+generator.generateWishMessage("raja"));
		//close container
		 ((ConfigurableApplicationContext) ctx).close();*/
		
		 ApplicationContext ctx=null;
		 WishGenerator generator=null;
		 ctx=SpringApplication.run(IocBootProj1Application.class, args);
		 
		  //close container
		 //((ConfigurableApplicationContext) ctx).close();
		 
	}
}
