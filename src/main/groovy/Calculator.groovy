/*
 * This Groovy source file was auto generated by running 'gradle buildInit --type groovy-library'
 * by 'robxpatrick' at '19/05/15 20:20' with Gradle 2.3
 *
 * @author robxpatrick, @date 19/05/15 20:20
 */
class Calculator {


    int add( String numbers ) {

        int result = 0

        if ( numbers ) {
            numbers.split( ',' ).each { number ->
                number.split( '\n' ).each {
                    result += it.trim().toInteger()
                }
            }
        }

        result
    }
}
