import random

def roll():
    die1 = random.randint(1, 6)
    die2 = random.randint(1, 6)
    rolldie = die1 + die2

    if die1 + die2 == 2:
        rolldie = -1
    elif die1 == 1 or die2 == 1:
        rolldie = 0
    
    print(str(die1) + " " + str(die2) + " " + "rolled: " + str(rolldie))
    return rolldie

print("Time to start Roll to 100!")
print("Careful, rolling a 1 and a 1 is a SnakeEyes -1: it erases score!")
name1 = input("Enter player 1 name: ")
name2 = input("Enter player 2 name: ")
limit = 100
score1 = 0
score2 = 0
current = True

while score1 < limit and score2 < limit:
    if current == True:
        print(name1 + " has the dice")
    else:
        print(name2 + " has the dice")
    print()

    currentscore = 0

    roll1 = input("Enter roll to roll: ")
    while roll1 != "roll":
        roll1 = input("roll not entered: ")
    
    start = roll()
    if start == -1:
        if current == True:
            score1 = 0
        else:
            score2 = 0
    if start <= 0:
        currentscore = 0
        print(name1 + ": " + str(score1))
        print(name2 + ": " + str(score2))
        print("1 rolled so Switch!")
        print()
        current = not current
    else:
        currentscore = currentscore + start

    if currentscore != 0:
        roll2 = input("Enter roll to roll again, stick to stick, scores to see scores: ")
        while roll2 != "roll" and roll2 != "stick" and roll2 != "scores":
                roll2 = input("Enter roll to roll again, stick to stick, scores to see scores: ")

        while roll2 != "stick":
            if roll2 == "scores":
                if current == True:
                    print(name1 + ": " + str(score1+currentscore))
                    print(name2 + ": " + str(score2))
                else:
                    print(name1 + ": " + str(score1))
                    print(name2 + ": " + str(score2+currentscore))
            
            if roll2 == "roll":
                again = roll()
                if again == -1:
                    print("Snake Eyes!")
                    if current == True:
                        score1 = 0
                    else:
                        score2 = 0
                if again <= 0:
                    currentscore = 0
                    print(name1 + ": " + str(score1))
                    print(name2 + ": " + str(score2))
                    print("1 rolled so Switch!")
                    print()
                    current = not current
                    break
                else:
                    currentscore = currentscore + again

            roll2 = input("Enter roll to roll again, stick to stick, scores to see scores: ")   

    if currentscore != 0:
        if current == True:
            score1 = score1 + currentscore
        else:
            score2 = score2 + currentscore

        print(name1 + ": " + str(score1))
        print(name2 + ": " + str(score2))
        print("Switch!")
        print()
        current = not current

if score1 >= limit:
    print("Game over! Victory for " + name1 + ", who has " + str(score1))

else:
    print("Game over! Victory for " + name2 + ", who has " + str(score2))