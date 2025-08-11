package com.aaslin.SpringProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aaslin.BeanInjections.College;
import com.aaslin.BeanInjections.Department;
import com.aaslin.BeanLifeCycle.TeacherThroughAnnotations;
import com.aaslin.BeanLifeCycle.TeacherThroughInterfaces;
import com.aaslin.BeanLifeCycle.TeacherThroughXml;
import com.aaslin.BeanScope.BeanScopePrototype;
import com.aaslin.BeanScope.BeanScopeSingleton;

public class MyApp 
{
    public static void main( String[] args )
    {    	
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        //CALLING COLLEGE BEAN
        College college = (College)context.getBean("college");
        System.out.print(college);
        
        //CALLING DEPARTMENT BEAN
        Department department = context.getBean("department", Department.class);
        System.out.println(department);       
        
        //CALLING INIT-METHOD AND DESTROY-METHOD THROUGH XML
        TeacherThroughXml teacherXml = context.getBean("teacher", TeacherThroughXml.class);
        teacherXml.destroy();
        
       
        // CALLING INIT-METHOD AND DESTROY-METHOD THROUGH INTERFACES
    	 
        ConfigurableApplicationContext configContext = new ClassPathXmlApplicationContext("beans.xml");
       
        TeacherThroughInterfaces teacherThroughInterfaces = configContext.getBean(TeacherThroughInterfaces.class);
        configContext.close();
        
     // CALLING INIT-METHOD AND DESTROY-METHOD THROUGH annotations
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();
        annotationContext.scan("com.aaslin.BeanLifeCycle");
        annotationContext.refresh();
        TeacherThroughAnnotations obj = annotationContext.getBean(TeacherThroughAnnotations.class);
        annotationContext.close();
        
        
        //Bean scope
        BeanScopeSingleton singleScope1 = (BeanScopeSingleton) context.getBean(BeanScopeSingleton.class);
        BeanScopeSingleton singleScope2 = (BeanScopeSingleton) context.getBean(BeanScopeSingleton.class);
        
        System.out.println("Singleton: ");
        System.out.println(singleScope1);
        System.out.println(singleScope2);
        
        System.out.println();
        
        System.out.println("prototype: ");
        BeanScopePrototype protoType1 =  (BeanScopePrototype) context.getBean(BeanScopePrototype.class);
        BeanScopePrototype protoType2 =  (BeanScopePrototype) context.getBean(BeanScopePrototype.class);
        System.out.println(protoType1);
        System.out.println(protoType2);
        
        
        }     
}
