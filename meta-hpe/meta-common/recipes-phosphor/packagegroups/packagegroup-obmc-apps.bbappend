RDEPENDS:${PN}-logging += "phosphor-logging"
RDEPENDS:${PN}-extras += " \
                           phosphor-image-signing \
                           phosphor-pid-control \
"

RDEPENDS:${PN}-fan-control = " \
         ${VIRTUAL-RUNTIME_obmc-fan-control} \
         "
