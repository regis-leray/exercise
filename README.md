[![Build Status](https://travis-ci.org/regis-leray/exercise.png?branch=master)](https://travis-ci.org/regis-leray/exercise)



#Traffic Flow

The Shallow Alto city council has organized a special committee to review the traffic situation in the city. Despite the fact that there is nothing whatsoever to do in the city, citizens still write
complaints about the amount of time it takes them to get from one unexciting location to the next.

The committee has been asked to figure out how long it takes someone to travel down the streets of Shallow Alto given the current traffic light programming. To do this, they want you to
write an algorithm which, given the speed a car travels down a road and the timing of the traffic lights, returns the amount of time it takes the car to travel down the street.

The traffic lights will be in an int[], with each element representing the amount of time in seconds between signal changes. Initially, all traffic lights have just turned green, and are at the
beginning of their cycle. The order of the traffic lights in the int[] will be the order in which a car encounters them.

The speed you will be given is in meters per second. Assume that the car starts 150 meters before the first traffic light, that there are 150 meters between each traffic light, and that the
car stops 150 meters after the last traffic light. Disregard all acceleration and deceleration; a car is either at its given speed or entirely stopped, and it takes no time to go from one state to the
other.

If a car reaches a traffic light just as it turns red, it immediately stops and waits for it to turn green again (at which point it starts moving immediately). If the light just turned green, there is
no wait and the car drives on through.

Return the time, in seconds, that it takes the car to travel the entire distance. Round down any fractional parts, (for example 55.5 becomes 55 and 44.9 becomes 44), but do not do this until
returning (see example #2 below).
Write an application that would calculate the time in seconds given the following inputs:

```
Inputs
    int[] lights and int speed

Output
    Time in seconds (int)
```


### Constraints

*speed will be either 5, 10, 15, 20, 25, or 30.
*lights will contain between 1 and 50 elements, inclusive.
*each element of lights will be an integer between 10 and 60, inclusive.

### Examples

```
0)
{10,10,10}
30
Returns: 30
The car reaches the first traffic light at time = 5, so the light is still green and the car drives on
through.
The car then reaches the second traffic light at time = 10, and the light has just turned red.
The car then waits 10 more seconds for the light to turn green.
At time = 20, the light is green and the car starts driving instantly at 30 meters/second.
At time = 25 the car hits the third traffic light, which is green.
At time = 30 the car reaches the end, 150 meters past the last traffic light.
```

```
1)
{10,10,10}
20
Returns: 35
time = 7.5 - the car reaches first light, which is green.
time = 15 - the car reaches second light, which is red.
time = 20 - the light turns green, and the car continues.
time = 27.5 - the car reaches third light, which is green.
time = 35 - the car reaches the end, 150 meters past the last traffic light.
```

```
2)
{10,20,30}
20
Returns: 35

time = 7.5 - the car reaches first light, which is green.
time = 15 - the car reaches second light, which is green.
time = 22.5 - the car reaches third light, which is green.
time = 30 - the car reaches the end.
```

```
3)
{10,11,12,13,14,15}
5
Returns: 240
time = 30 - the car reaches first light, which just turned red.
time = 40 - the light turns green, and the car continues.
time = 70 - the car reaches the second light, which is green.
time = 100 - the car reaches the third light, which is green.
time = 130 - the car reaches the fourth light, which is green.
time = 160 - the car reaches the fifth light, which is red.
time = 168 - the light turns green, and the car continues.
time = 198 - the car reaches the sixth light, which is red.
time = 210 - the light turns green, and the car continues.
time = 240 - the car reaches the end.
```

```
4)
{60,60,60,60,60,60,60,60,60,60}
5
Returns: 630
```

```
5)
{55,29,26,12,19,39,18,20,23,28,56,20,59,48,33,40,30,60,19}
25
Returns: 252
```

#Basic Sales

Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported
goods at a rate of 5%, with no exemptions. When I purchase items I receive a receipt which lists the name of all the items and their price
(including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains
(np/100 rounded up to the nearest 0.05) amount of sales tax. Write an application that prints out the receipt details for these shopping baskets...

```
INPUT:
Input 1:
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85
Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50
Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25


OUTPUT

Output 1:
1 book : 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83

Output 2:
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15

Output 3:
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68
```
