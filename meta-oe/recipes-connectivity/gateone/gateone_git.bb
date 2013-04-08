DESCRIPTION = "HTML5 (plugin-free) web-based terminal emulator and SSH client"
LICENSE = "AGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ee5b168fc7de89a0cadc49e27830aa2c"

PR = "r8"

PV = "1.1"
SRCREV = "ea5db3dcb3bbbe445ae6d1a5611c1f8d547c57b9"
SRC_URI = "git://github.com/liftoff/GateOne.git \
           file://gateone-avahi.service \
           file://server.conf \
          "

S = "${WORKDIR}/git"

inherit distutils allarch

export prefix = "${localstatedir}/lib"

do_install_append() {
	install -d ${D}${localstatedir}/log/${BPN}

	install -m 0755 -d ${D}${sysconfdir}/avahi/services/
	install -m 0644 ${WORKDIR}/gateone-avahi.service ${D}${sysconfdir}/avahi/services/

	install -m 0644 ${WORKDIR}/server.conf ${D}/var/lib/gateone/server.conf
}

FILES_${PN} = "${localstatedir}/lib ${localstatedir}/log ${base_libdir} ${sysconfdir} ${libdir}/python*"
RDEPENDS_${PN} = "file \
                  mime-support \
                  openssh-ssh \
                  python-compression \
                  python-crypt \
                  python-datetime \
                  python-email \
                  python-fcntl \
                  python-html \
                  python-imaging \
                  python-io \
                  python-json \
                  python-logging \
                  python-misc \
                  python-multiprocessing \
                  python-netclient \
                  python-pkgutil \
                  python-pyopenssl \
                  python-re \
                  python-readline \
                  python-shell \
                  python-simplejson \
                  python-subprocess \
                  python-syslog \
                  python-terminal \
                  python-textutils \
                  python-tornado \
                  python-unixadmin \
                  python-xml \
                 "
