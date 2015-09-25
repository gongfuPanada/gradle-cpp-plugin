package fr.echoes.gradle.plugins.cpp

import spock.lang.Specification


/**
 * Created by jguidoux on 07/09/15.
 */
class UtilsSpec extends Specification{

    class Person {
        def name
    }

    def "add age property to a class"() {
        given:
        def person = new Person(name: "halyna")

        when:
        person.metaClass.age = 2

        then:
        person.age == 2
    }

    def "find properties number when added dinamcally"() {
        given:

        def person = new Person(name: "halyna")

        when:
        person.metaClass.age = 2
        person.properties.each {
            println it.key
        }

        println "mon nom est ${person.name}"


        then:
        person.properties.containsKey("age")
    }
}