# 1. Describe the process of how would you check if a server OR a service (http, http over tls, icmp) on a server is running?

##### The process is simple. You can use many tools already integrated in your system.
##### Many simple commands exist for testing different protocols individually but for this homework I decided to use a tool that scans the whole network for open ports and services. The tool is called **nmap**. Sample commands for testing if server is running:
&nbsp;
```
ping <address>
curl -v <address>
```
&nbsp;
# 2. What services are running on the mentormate gitlab server (i.e. gitlab.mentormate.bg) when you are connected to the VPN and when you are not connected to it?

- # VPN ON:
```sh
Starting Nmap 7.80 ( https://nmap.org ) at 2020-08-22 16:41 FLE Daylight Time
WARNING: Could not import all necessary Npcap functions. You may need to upgrade to the latest version from https://npcap.org. Resorting to connect() mode -- Nmap may not function completely
Nmap scan report for gitlab.mentormate.bg (192.168.4.100)
Host is up (0.0019s latency).
Not shown: 88 filtered ports
PORT    STATE SERVICE
22/tcp  open  ssh
25/tcp  open  smtp
80/tcp  open  http
110/tcp open  pop3
111/tcp open  rpcbind
119/tcp open  nntp
143/tcp open  imap
443/tcp open  https
465/tcp open  smtps
587/tcp open  submission
993/tcp open  imaps
995/tcp open  pop3s
Nmap done: 1 IP address (1 host up) scanned in 4.70 seconds
```

- # VPN OFF:
```sh
Starting Nmap 7.80 ( https://nmap.org ) at 2020-08-22 18:29 FLE Daylight Time
WARNING: Could not import all necessary Npcap functions. You may need to upgrade to the latest version from https://npcap.org. Resorting to connect() mode -- Nmap may not function completely
Nmap scan report for gitlab.mentormate.bg (195.230.1.186)
Host is up (0.0018s latency).
Other addresses for gitlab.mentormate.bg (not scanned): 217.79.32.202
rDNS record for 195.230.1.186: host-186-1-230-195.d2-online.net
Not shown: 89 filtered ports
PORT     STATE SERVICE
22/tcp   open  ssh
25/tcp   open  smtp
110/tcp  open  pop3
119/tcp  open  nntp
143/tcp  open  imap
443/tcp  open  https
465/tcp  open  smtps
587/tcp  open  submission
993/tcp  open  imaps
995/tcp  open  pop3s
1723/tcp open  pptp
Nmap done: 1 IP address (1 host up) scanned in 5.04 seconds
```

# Conclusion

The same services are running on the server and it doesn't matter if you are using VPN or not.
The thing is that the server uses HSTS. It first tries to verify your network before giving you a response.

>HTTP Strict Transport Security (HSTS) is a web security policy mechanism that helps to protect websites against man-in-the-middle attacks such as protocol downgrade attacks[1] and cookie hijacking. It allows web servers to declare that web browsers (or other complying user agents) should automatically interact with it using only HTTPS connections, which provide Transport Layer Security (TLS/SSL), unlike the insecure HTTP used alone. HSTS is an IETF standards track protocol and is specified in RFC 6797.