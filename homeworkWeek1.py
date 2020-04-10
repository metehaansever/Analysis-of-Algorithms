import random
#random sayılar oluşturuldu.
def random_numbers(n,min,max):
    numbers=[]
    for i in range(n): 
        numbers.append(random.randint(min,max))
    return numbers


def getModeMedian(list_1):
    n=len(list_1)
    frequency_max=-1
    mode=-1
    frequency_dict={} 

#liste sıralandı.
    for i in range(n-1,-1,-1):
        for j in range(0,i):
            if not(list_1[j]<list_1[j+1]):
                temp=list_1[j]      
                list_1[j]=list_1[j+1]      
                list_1[j+1]=temp
    print("List: "+str(list_1))


    for item in list_1:
        if (item in frequency_dict):
            frequency_dict[item]=frequency_dict[item]+1
        else:
            frequency_dict[item]=1
    print("Dict of List: "+str(frequency_dict))
    
    #Median bulundu.
    median=0
    if n%2==1:
        middle=int(n/2)
        median=list_1[middle]
    else:
        middle_1=list_1[int(n/2)-1]
        middle_2=list_1[int(n/2)]
        median=(middle_1+middle_2)/2

    mode=0
    for key in frequency_dict.keys():
        if frequency_dict[key]>frequency_max:
            frequency_max=frequency_dict[key]
            mode=key


    return mode,median



list_1=random_numbers(10,-4,4)
mode,median=getModeMedian(list_1)
print("mode: {} median:{}".format(mode,median))
