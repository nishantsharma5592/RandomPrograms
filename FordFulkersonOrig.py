#<18973, Nishant Sharma> [No longer active]

#<Email: nishant.sharma@vit.ac.in> [No longer active]

# There is input() in the program; Press enter when the program stops.


'''

FORD-FULKERSON-METHOD (G, s, t):

 initialize flow f to 0

 while there exists an augmenting path p in the residual network G:

  augment flow f along p

 return f

'''



# A graph is a list of edges. Edges are represented by source name, flow, capacity and destination node



graph = [['s', 0, 16, 'a'], ['s', 0, 13, 'b'], ['b', 0, 4, 'a'], ['a', 0, 12, 'c'], ['c', 0, 9, 'b'], ['b', 0, 14, 'd'], ['d', 0, 7, 'c'], ['d', 0, 4, 't'], ['c', 0, 20, 't']]



collect = []



def residualGraph():

    global graph

    residual_graph = []

    # Residual graph contains 2 types of edges:

    #   => One that can be in the forward direction.

    #   => The other that can represent the flow being sent back

    for each in graph:

        if (each[2]-each[1]>0):

            newEach = []

            newEach += [each[0]]

            newEach += [each[2] - each [1]]

            newEach += [each[2]]

            newEach += [each[3]]

            residual_graph += [newEach]

        if (each[1] > 0):

            newEach = []

            newEach += [each [3]]

            newEach += [each [1]]

            newEach += [each [1]]

            newEach += [each [0]]

            residual_graph += [newEach]

    return residual_graph



# This is a tricky function:


def simplePath(source, residualGraph, visited):

    global collect

    # We wish to maintain a visited list to avoid cycling over the vertices

    if source in visited:

        return [None]

    if source == 't':

        return []

    visited += [source]

    edgesFromSource = [edge for edge in residualGraph if edge[0] == source] 

    for edge in edgesFromSource:

        newSource = edge[3]

        # This is the tricky part:

        # => Intuitively it means: If following this path takes you to the right destination, then follow that path 

        if (simplePath(newSource, residualGraph, visited) != [None] ):

            # Collect what is important [edges] along the path

            collect = collect + [edge] + simplePath(newSource,residualGraph, visited)

            # Return those edges:

            return [ele for ele in collect if ele != None]

    return [None]



def fordFulkerson():

    global collect

    global graph

    while (True):

        collect = []

        residual_graph = residualGraph()

        #for each in residual_graph:

            #print(each)

        print("Residual Graph: => ")

        print (residual_graph)

        simplePathList = simplePath('s', residual_graph, [])

        reversedList = []

        for i in range (len(simplePathList)-1,-1, -1):

            reversedList = reversedList + [simplePathList[i]]

        simplePathList = reversedList

        # If no augmenting path exists: then break the forever loop:

        if (simplePathList == [None]):

            break

        print("Augment path for your reference: =>")

        print(simplePathList)

        # Find how much we can augment along that path

        augmentable_flow = min([each[1] for each in simplePathList])

        print(augmentable_flow)

        # Augment the original graph by augmentable flow along SimplePathList:

        for each in simplePathList:

            for element in graph:

                # If it is a positive edge in the augmenting path list then add augmentable flow to that edge

                if (each[0] == element[0] and each[3] == element[3]):

                    element[1]+=augmentable_flow

                # If it is a reverse edge in the residual graph, then subtract the augmentable flow from that edge

                elif (each[0] == element[3] and each[3] == element[0]):

                    element[1]-=augmentable_flow

        print("New Graph: =>")

        print(graph)

        input()

    

if (__name__ == '__main__'):

    #print(residualGraph())

    #print(simplePath('s',graph,[]))

    fordFulkerson()
