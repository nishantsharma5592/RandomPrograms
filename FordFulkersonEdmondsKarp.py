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





# The change in Edmond Karp is to change the DFS simplePath Algorithm implemented first to a BFS simple path algorithm implemented now:

def simplePathBFS(source, residualGraph, visited):

    

    # This is an auxiliary helper function that backtraces simple path from destination to source using the predecessor list maintained by the simplePathBFS function

    def backTrace(node):

        if (node == 's'):

            return []

        for each in predecessor_list:

            if (each[3] == node):

               # This return statement does a call before the append, and hence ensures that we do not need to reverse the backTrace path obtained

               return backTrace(each[0]) + [each]

      



    node_list = []

    node_list.append('s')

    predecessor_list = []

    flag = False # flag = true indicates that there is no possible forward edge selection from a given source. We must stop our search for augmenting path as none exists now.

    



    while(True):

        if (node_list == []):

            flag = True

            break

        current_source = node_list.pop(0)

        # We maintain a list of visited nodes to avoid circling through the residual graph again and again

        visited += [current_source]

        print("Current Source: ", current_source)

        for each in residualGraph:

            if (each[0] == current_source):

                if (each[3] not in visited):

                    # if the destination node has not already been visited, only then add it to the node_list for further processing

                    node_list.append(each[3])

                    # Update our predecessor list as well

                    # Note that our predecessor list is just a list of encountered egdes from the residual graph. The edges maintain the predecessor information because they have edge[0] --> edge [3] relationship where edge[0] is the predecessor of edge[3]

                    predecessor_list.append(each)

                # If we found an edge that has its destination as 't' then we return the backtraced list from 's' to 't'

                if 't' in node_list:

                    return backTrace('t')

        # Debugging information for our visualizing our output:

        print("Node List: ", node_list)

        print("Predecessor List: ", predecessor_list)

        input()

    

    # If flag is True, then we could not find an augmenting path from 's' to 't', and in that case we return None 

    if (flag == True):

        return [None]

             







def fordFulkersonEdmondKarp():

    global graph

    while (True):

        collect = []

        residual_graph = residualGraph()

        #for each in residual_graph:

            #print(each)

        print("Residual Graph: => ")

        print (residual_graph)

        

        simplePathList = simplePathBFS('s', residual_graph, [])

        

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

    #print(simplePathBFS('s',graph,[]))

    fordFulkersonEdmondKarp()
