#
kubectl delete deploy -l app=fake-load-1
kubectl delete deploy -l app=fake-load-2
kubectl delete deploy -l app=fake-load-3
kubectl delete deploy -l app=k8-metrics
kubectl delete role --all
kubectl delete rolebinding --all
#
kubectl create deployment fake-load-1 --image registry.hub.docker.com/gregclinker/fake-load:0.1 --replicas 0
kubectl set resources deployment fake-load-1 --requests cpu=500m,memory=512Mi --limits cpu=1,memory=1Gi
kubectl set env deploy fake-load-1 --env MEM_TO_USE_MI=128 --env THREADS_TO_RUN=2
kubectl scale deployment fake-load-1 --replicas 1
#
kubectl create deployment fake-load-2 --image registry.hub.docker.com/gregclinker/fake-load:0.1 --replicas 0
kubectl set resources deployment fake-load-2 --requests cpu=500m,memory=512Mi --limits cpu=1,memory=1Gi
kubectl set env deploy fake-load-2 --env MEM_TO_USE_MI=256 --env THREADS_TO_RUN=4
kubectl scale deployment fake-load-2 --replicas 1
#
kubectl create deployment fake-load-3 --image registry.hub.docker.com/gregclinker/fake-load:0.1 --replicas 0
kubectl set resources deployment fake-load-3 --requests cpu=500m,memory=1Gi --limits cpu=1,memory=2Gi
kubectl set env deploy fake-load-3 --env MEM_TO_USE_MI=512 --env THREADS_TO_RUN=6
kubectl scale deployment fake-load-3 --replicas 1
#
kubectl create role k8-metrics --verb=get,list,watch --resource=pods --resource=pods.metrics.k8s.io
kubectl create rolebinding k8-metrics --role k8-metrics --serviceaccount fake-load:default
kubectl create deployment k8-metrics --image registry.hub.docker.com/gregclinker/k8-metrics:0.1
#