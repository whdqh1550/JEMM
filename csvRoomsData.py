import csv
import random
from datetime import datetime
header = ["roomNum","firstName", "lastName","phoneNum","dateStart","dateEnd","numGuests","isAvailable"]
 #{ford=[firstName, lastName, phoneNumber, dateStart, dateEnd, ]}
numData =100
listRooms = []

firstNames = open("names.txt").read()
firstNames = firstNames.split()
# print(firstNames)
lastNames = open("lastNames.txt").read()
lastNames = lastNames.split()
# print(lastNames)

dataFinal = []

for i in range(numData):

    listData = []
    randRoom = random.randint(1,numData)
    while listRooms.count(randRoom) != 0:

        randRoom = random.randint(1, numData)
    listData.append(randRoom)
    listRooms.append(randRoom)

    firstName = random.choice(firstNames)
    listData.append(firstName)
    lastName = random.choice(lastNames)
    listData.append(lastName)

    phoneNumber = random.randint(1000000000, 9999999999)
    phoneNumber = str(phoneNumber)
    phoneNumber = phoneNumber[0:3] + "-"+ phoneNumber[3:6] +"-"+ phoneNumber[6:]
    listData.append(phoneNumber)

    month1 = '%02d'%(random.randint(1, 12))
    day1 = '%02d'%(random.randint(1, 30))
    if int(month1) == 2:
        day1 = '%02d' % (random.randint(1, 28))
    # hour = '%02d'%(random.randint(1, 24))
    # min = '%02d'%(random.randint(1, 59))
    dateStart = "{0}-{1}-2022".format(month1, day1)
    listData.append(dateStart)
    checkEarlier = int(month1 + day1)
    listSeperateMonth = [0, 1, 0, 0, 0]
    month2 = 0
    if not int(month1) == 12:
        month2 = '%02d'%(int(random.choice(listSeperateMonth))+int(month1))
    else:
        month2 = '%02d'%(12)
    day2 = '%02d'%(random.randint(1, 29))
    if int(month2) == 2:
        day2 = '%02d' % (random.randint(1, 28))
        if day2 == day1:
            day2 =str(int(day2)+1)
    if day2 == day1:
        day2 =str(int(day2)+1)
    checkLater = int(month2 + day2)

    while checkLater < checkEarlier:
        month2 = '%02d' % (random.choice(listSeperateMonth))
        if not int(month1) == 12:
            month2 = '%02d' % (int(random.choice(listSeperateMonth)) + int(month1))
        else:
            month2 = '%02d' % (12)
        day2 = '%02d' % (random.randint(1, 29))
        if day2 == day1:
            day2 = str(int(day2)+1)
        if int(month2) == 2:
            day2 = '%02d' % (random.randint(1, 28))
            if day2 == day1:
                day2 = str(int(day2) + 1)
        checkLater = int(month2 + day2)
    # print(checkEarlier, checkLater)#######################################
    # hour = '%02d'%(random.randint(1, 24))
    # min = '%02d'%(random.randint(1, 59))
    dateEnd = "{0}-{1}-2022".format(month2, day2)
    listData.append(dateEnd)

    numGuests = random.randint(0,4)
    listData.append(numGuests)

    listBool = [True, False]
    isAvailable = random.choice(listBool)
    listData.append(isAvailable)
    if isAvailable:
        listData[1:-1] = ['','','','','','',]
    # data = "{0}=[{1}, {2}, {3}, {4}]".format(listRooms[i], firstName, lastName,
    #                                                dateStart, dateEnd)
    print(listData)
    dataFinal.append(listData)
    # dataFinal +=  data
    # if i != numData -1:
    #     dataFinal += ","
print(dataFinal)
# print(dataFinal)
# dataFinal += "}"
# dataFinal = "{" + dataFinal[:]
# print(dataFinal)
    # dataString = ''.join(data)
# print(data)

with open('data.csv', 'w', encoding='UTF8', newline='') as f:
    writer = csv.writer(f)

    # write the header
    writer.writerow(header)

    # write multiple rows
    writer.writerows(dataFinal)


