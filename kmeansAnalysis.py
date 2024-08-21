import pandas as pd
import numpy as np
import random
import math
import matplotlib.pyplot as plt

def calc_distance(data, centroids, NUM_DATA_ROWS, NUM_CLUSTERS):
    distances = np.zeros((NUM_DATA_ROWS, NUM_CLUSTERS))

    for i in range(NUM_DATA_ROWS):
        for j in range(NUM_CLUSTERS):
            first = data[i]
            second = centroids[j]
            distances[i][j] = math.sqrt(math.pow(second[0] - first[0], 2) + math.pow(second[1] - first[1], 2))

    return distances

def cluster(data, distances, NUM_DATA_ROWS, NUM_DATA_COLS, NUM_CLUSTERS):
    closest_centroids = np.zeros((NUM_DATA_ROWS, 1))
    for i in range(NUM_DATA_ROWS):
        closest_centroids[i] = np.argmin(distances[i])

    updated_data = np.column_stack((data, closest_centroids))

    averages = []
    for i in range(NUM_CLUSTERS):
        average_cluster = []
        for j in range(NUM_DATA_ROWS):
            if updated_data[j][NUM_DATA_COLS] == i:
                average_cluster.append(list(data[j]))
        averages.append(average_cluster)
    
    updated_centroids = np.zeros((NUM_CLUSTERS, NUM_DATA_COLS))

    for i in range(NUM_CLUSTERS):
        for j in range(NUM_DATA_COLS):
            average_vals = [averages[i][l][j] for l in range(len(averages[i]))]
            updated_centroids[i][j] = sum(average_vals) / len(average_vals)
    
    return updated_centroids

def kmeans(data, NUM_CLUSTERS, NUM_ITERATIONS):

    NUM_DATA_ROWS = data.shape[0]
    NUM_DATA_COLS = data.shape[1]

    num_centroid_rows = 0
    rand_rows = []
    centroids = np.zeros((NUM_CLUSTERS, NUM_DATA_COLS))

    while num_centroid_rows < NUM_CLUSTERS:
        num_rand_row = random.randint(0, NUM_DATA_ROWS - 1)

        if num_rand_row not in rand_rows:
            rand_rows.append(num_rand_row)
            centroids[num_centroid_rows] = data[num_rand_row]
            num_centroid_rows += 1

    for _ in range(NUM_ITERATIONS):
        dist = calc_distance(data, centroids, NUM_DATA_ROWS, NUM_CLUSTERS)
        centroids = cluster(data, dist, NUM_DATA_ROWS, NUM_DATA_COLS, NUM_CLUSTERS)
    
    data_x = [data[i][0] for i in range(NUM_DATA_ROWS)]
    data_y = [data[j][1] for j in range(NUM_DATA_ROWS)]
    centroids_x = [centroids[i][0] for i in range(centroids.shape[0])]
    centroids_y = [centroids[j][1] for j in range(centroids.shape[0])]

    plt.scatter(data_x, data_y, alpha = 0.5)
    plt.scatter(centroids_x, centroids_y, color = 'r')
    plt.title("Longitude vs. Latitude Plot of Uber Ride Requests")
    plt.xlabel("Latitude")
    plt.ylabel("Longitude")
    plt.show()
    
    return centroids

"""
Read your raw Uber data csv file in below
"""
uber_data = None

lat_data = uber_data['Lat'].to_list()
lon_data = uber_data['Lon'].to_list()
data = np.column_stack((lat_data, lon_data))

"""
Set desired number of clusters and iterations.
"""
clusters = 6
iterations = 20

print("Figures plotted respectively correspond to all data, weekday mornings, weekday afternoons, weekday evenings")

print()
print(str(clusters) + " optimal locations for Uber drivers to idle:")
print(kmeans(data, clusters, iterations))

"""
Read more data in below to compare/contrast, if desired.
"""
more_uber_data = []
more_data = []

for dat in more_uber_data:
    lat_dat = dat['Lat'].to_list()
    lon_dat = dat['Lon'].to_list()
    more_data.append(np.column_stack((lat_dat, lon_dat)))

print()
print(kmeans(more_data[0], clusters, iterations))

print()
print(kmeans(more_data[1], clusters, iterations))

print()
print(kmeans(more_data[2], clusters, iterations))

# Analysis can continue on as needed...




