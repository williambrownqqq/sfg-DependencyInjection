package com.zanchenko.alexey.sfgDependencyInjetion;

import com.zanchenko.alexey.sfgDependencyInjetion.controllers.ConstructorInjectedController;
import com.zanchenko.alexey.sfgDependencyInjetion.controllers.MyController;
import com.zanchenko.alexey.sfgDependencyInjetion.controllers.PropertyInjectedController;
import com.zanchenko.alexey.sfgDependencyInjetion.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDependencyInjetionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDependencyInjetionApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController");
		//So now I'm getting a handle on the Spring application context and I can actually ask that context
		//for an instance of my controller so say my controller equals and I need to do a cast here because it
		//just returns back an object type.
		String greeting = myController.sayHello();
		//Context because when the starts up Spring is going to go through, scan for beans.
		//Things have been annotated as beans and create those into the context.
		//So what's gonna happen here is I'm asking the context for the controller. I am getting the return value
		//and the greeting.
		System.out.println(greeting);

		//Now one thing I do want to point out here is notice that I never asked never created that controller
		//object.
		//Nowhere in the code did I say new controller. The spring framework is actually doing that for us.
		System.out.println(" ----------- Property -------------");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());
		System.out.println(" ----------- Setter -------------");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreetingService());
		System.out.println(" ----------- Constructor -------------");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreetingService());

		//And then when we run our application now we have effectively four different Spring beans being brought
		//
		//into the context so we have the greeting service itself that implantation. Spring is instantiating that.
		//
		//And then it's also scanning and seeing that we have the four different controllers.
		//
		//I'm sorry that need to be brought into the context and it sees that our property injected controller
		//
		//Setter injected controlling, constructor injected controller, all have a dependency on the greeting service.
		//
		//And when it constructs those beans, it automatically wires those up with that greeting service.
	}

}

// What's happening underneath the covers.
//
//Spring is creating that. So inside the Spring Context, Spring effectively is saying create a new instance
//
//of this class, put it into the context, and then when I run here what's happening is on line 14 I'm saying
//
//hey Spring I want an instance of this so from the context provide me an instance of this bean.
//
//So the Spring that's how the inversion of control works.
//The Spring Framework is managing the construction of myController.
//So Spring is providing it.
//
//So I'm not creating a new object there.
//
//I'm asking Spring to provide me an object there.
//So this is like one of the fundamental tenants of Dependency Injection is to have the framework doing
//
//all the management of it.
//
//So the framework is going out and creating those objects for you and providing those instantiated objects.
//
//You can see there I did not create it myself.
//
//I asked the framework for an instance of that object.


//@Qualifier - this qualifier is just giving Spring a hint as to which bean you want to have injected.
//So here we've created that greeting service interface. We have three Spring components that qualify for
//this Dependency Injection because they all implement that interface. But Spring doesn't know which one
//we want to be injected.
//So I throw an error when it couldn't make a determination which one to add. We put in the qualifier hint
//So Spring now knows which one of these controllers gets which instance of the service.