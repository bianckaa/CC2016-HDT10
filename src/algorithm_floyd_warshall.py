"""
Universidad del Valle de Guatemala
Algoritmos y Estructuras de Datos - Seccion 31
Hoja de Trabajo 10
Biancka Raxón 24960

Descripción:
Implementación del algoritmo de Floyd-Warshall usando NetworkX

"""

import networkx as nx

# Crear grafo
graph = nx.DiGraph()

# Nodos (ciudades)
cities = ["Ciudad de Guatemala", "Zacapa", "Chiquimula", "Quetzaltenango", "Cobán"]
for city in cities:
    graph.add_node(city)

# Agregar aristas con respectivos pesos
edges = [
    ("Ciudad de Guatemala", "Zacapa", 3),
    ("Ciudad de Guatemala", "Quetzaltenango", 7),
    ("Zacapa", "Chiquimula", 1),
    ("Zacapa", "Cobán", 8),
    ("Chiquimula", "Quetzaltenango", 2),
    ("Quetzaltenango", "Cobán", 3),
    ("Cobán", "Ciudad de Guatemala", 4),
]

graph.add_weighted_edges_from(edges)

# Calcular matriz de caminos más cortos usando Floyd-Warshall
shortest_paths = dict(nx.floyd_warshall(graph))

# Imprimir matriz de caminos más cortos
print("Matriz de caminos más cortos:")
for from_city in cities:
    for to_city in cities:
        dist = shortest_paths[from_city][to_city]
        if dist == float('inf'):
            print("INF", end="\t")
        else:
            print(int(dist), end="\t")
    print()

# Encontrar el centro del grafo 
def find_graph_center(distance_matrix, nodes):
    """
    Encuentra el centro del grafo, es decir, la ciudad con la menor distancia máxima hacia otras.

    Parámetros:
        distance_matrix (dict): Diccionario con las distancias más cortas entre nodos.
        nodes (list): Lista de nombres de los nodos (ciudades).

    Retorna:
        str: El nombre de la ciudad que es el centro del grafo.
    """
    min_max_dist = float('inf')
    center = None
    for node in nodes:
        max_dist = max(distance_matrix[node].values())
        if max_dist < min_max_dist:
            min_max_dist = max_dist
            center = node
    return center

center_city = find_graph_center(shortest_paths, cities)
print(f"\nEl centro del grafo es: {center_city}")

