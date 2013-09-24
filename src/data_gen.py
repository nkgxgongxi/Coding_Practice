import numpy as np

def main():
    my_rand = np.random.RandomState()
    data = np.genfromtxt('adult.owner', dtype='int', delimiter=',', comments='@', unpack = True)
#     print (data)
    TRIAL_COUNT = 100
    queryPool = []
    NDIM = data.shape[0]
    DEFAULT_LOW = np.array([int(np.min(data[dim,:])) for dim in range(NDIM)])
    DEFAULT_HIGH =  np.array([int(np.max(data[dim,:])) for dim in range(NDIM)])
#     print (DEFAULT_LOW, DEFAULT_HIGH)
    fraction = get_fraction(my_rand, NDIM, 0.3, 0.7)
    rangeLength = np.around(np.array((DEFAULT_HIGH - DEFAULT_LOW + [1]*NDIM))*fraction)
    startUbound = DEFAULT_HIGH - rangeLength + [1]*NDIM
    start_mat = np.zeros((TRIAL_COUNT,NDIM))
    for i in range(NDIM):
        if DEFAULT_LOW[i]< startUbound[i]:
            start_mat[:,i] = my_rand.randint(DEFAULT_LOW[i],startUbound[i],TRIAL_COUNT)
        else:
            start_mat[:,i] = [DEFAULT_LOW[i]]*TRIAL_COUNT
    for i in range(TRIAL_COUNT):
        queryPool.append(np.array([start_mat[i,:],start_mat[i,:] + rangeLength- [1]*NDIM]).astype(int))
#     print (queryPool)
    for i in range(TRIAL_COUNT):
        print ("%d,%d,%d,%d,%d,%d,%d,%d,%d,%d" % (queryPool[i][0][0], queryPool[i][0][1],queryPool[i][0][2],queryPool[i][0][3],queryPool[i][0][4]
                             ,queryPool[i][1][0], queryPool[i][1][1],queryPool[i][1][2],queryPool[i][1][3],queryPool[i][1][4]))

def get_fraction(my_rand,NDIM,frac_low,frac_hi):

    fraction = my_rand.uniform(frac_low,frac_hi,NDIM)
#     print (fraction)
    return fraction
main()